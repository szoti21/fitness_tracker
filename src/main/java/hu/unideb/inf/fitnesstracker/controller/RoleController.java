package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.RoleEntity;
import hu.unideb.inf.fitnesstracker.data.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    public List<RoleEntity> getRoles(){
        return roleRepository.findAll();
    }

    @GetMapping("/{roleId}")
    public RoleEntity getById(@PathVariable("roleId") int roleId){
        return roleRepository.findById(roleId).orElse(null);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("")
    public RoleEntity saveRole(@RequestBody RoleEntity role){
        return roleRepository.save(role);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/{roleId}")
    public RoleEntity updateRole(@RequestBody RoleEntity role) {
        if(role.getRoleId() > 0L){
            return roleRepository.save(role);
        } else {
            return null;
        }
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable("roleID") int roleId){
        roleRepository.deleteById(roleId);
    }
}
