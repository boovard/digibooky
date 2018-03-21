package be.thebest.api.admins;

import be.thebest.domain.objects.persons.Admin;

import javax.inject.Named;

@Named
public class AdminMapper {

    public AdminDto toDto(Admin admin) {
        return AdminDto.adminDto()
                .withUniqueID(admin.getUniqueID())
                .withLastName(admin.getLastName())
                .withFirstName(admin.getFirstName())
                .withEmail(admin.getEmail());
    }

    public Admin toDomain(AdminDto adminDto){
        return (Admin)Admin.AdminBuilder.admin()
                .withUniqueID(adminDto.getUniqueID())
                .withLastName(adminDto.getLastName())
                .withFirstName(adminDto.getFirstName())
                .withEmail(adminDto.getEmail())
                .build();
    }
}
