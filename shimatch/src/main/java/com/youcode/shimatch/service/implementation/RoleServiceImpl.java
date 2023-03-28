package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Role;
import com.youcode.shimatch.repository.RoleRepository;
import com.youcode.shimatch.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(Long id) throws Exception {
        Optional<Role> optionalRole = roleRepository.findRoleById(id);

        if (optionalRole.isPresent()) {
            return optionalRole.get();
        } else {
            throw new Exception("Role n'exist pas");
        }
    }

    @Override
    public List<Role> gettAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Integer deleteRoleById(Long id) {
        try{
            roleRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
