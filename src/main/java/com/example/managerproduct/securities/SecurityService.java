package com.example.managerproduct.securities;

import com.example.managerproduct.domain.Employee;
import com.example.managerproduct.response.EmployeeRepository;
import com.example.managerproduct.response.RoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SecurityService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;


    public SecurityService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userToLower =username.toLowerCase(Locale.ENGLISH);

        return this.employeeRepository.findOneWithAuthoritiesByUsername(username)
                .map(user -> createSpringSecurityUser(userToLower, user))
                .orElseThrow(() -> new UsernameNotFoundException("User "+ userToLower +" not found"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseUser, Employee user) {
        if (user.getDisable() == 1) {
            throw new UsernameNotFoundException("User " + lowercaseUser + " was not activated");
        }

        List<GrantedAuthority> grantedAuthorities = this.roleRepository.findAll()
                .stream().map(auth -> new SimpleGrantedAuthority(auth.getRoleName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }
}
