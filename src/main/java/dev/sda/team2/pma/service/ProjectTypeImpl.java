package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.ProjectTypeRepository;
import dev.sda.team2.pma.entity.ProjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeImpl implements IProjectTypeService {

    private final ProjectTypeRepository projectTypeRepository;

    @Autowired
    public ProjectTypeImpl (ProjectTypeRepository theProjectTypeRepository){projectTypeRepository = theProjectTypeRepository;}

    @Override
    public List<ProjectType> findAll() {return projectTypeRepository.findAll();}

    @Override
    public ProjectType findById(long theId) {

        Optional<ProjectType> result = projectTypeRepository.findById(theId);
        ProjectType theProjectType;
        if (result.isPresent()){
            theProjectType = result.get();
        } else {
            throw new RuntimeException("Did not find project type id" + theId);
        }
        return theProjectType;
    }

    @Override
    public void save(ProjectType theProjectType){
        projectTypeRepository.save(theProjectType);
    }

    @Override
    public void deleteById(long theId) {
        projectTypeRepository.deleteById(theId);
    }
}
