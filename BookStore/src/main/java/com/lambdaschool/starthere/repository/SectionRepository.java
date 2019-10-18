package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<Section, Long>
{
}
