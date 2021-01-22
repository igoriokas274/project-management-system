package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.DepartmentRepository;
import dev.sda.team2.pma.entity.Department;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl (DepartmentRepository theDepartmentRepository) {
        departmentRepository = theDepartmentRepository;
    }

    @Override
    public List<Department> findAll() {return departmentRepository.findAll();}

    @Override
    public Department findById(long theId) {

        Optional<Department> result = departmentRepository.findById(theId);
        Department theDepartment;
        if (result.isPresent()) theDepartment = result.get();
        else {
            throw new RuntimeException("Did not find department id" + theId);
        }
        return theDepartment;
    }

    @Override
    @Transactional
    @Audit(action = "Department saved")
    public void save(Department theDepartment) {
        departmentRepository.save(theDepartment);

    }

    @Override
    @Transactional
    @Audit(action = "Department deleted")
    public void deleteById(long theId) {

    }
}
