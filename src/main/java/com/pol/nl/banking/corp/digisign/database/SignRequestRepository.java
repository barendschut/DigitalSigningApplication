package com.pol.nl.banking.corp.digisign.database;

import com.pol.nl.banking.corp.digisign.resource.SignRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface to perform CRUD operations on SignRequest entity
 *
 */
public interface SignRequestRepository extends PagingAndSortingRepository<SignRequest, Long> {

    @Query("select req from SignRequest as req where req.employee.id = :employeeId")
    List<SignRequest> getAllSignRequests(Pageable pageable, @Param("employeeId") Long employeeId);
}
