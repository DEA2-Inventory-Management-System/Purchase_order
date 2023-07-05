package com.example.purchase.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RequestRepository extends JpaRepository<Request,Integer>, JpaSpecificationExecutor<Request> {


}
