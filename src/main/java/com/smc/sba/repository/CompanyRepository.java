package com.smc.sba.repository;

import com.smc.sba.entity.CompanyEntity;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName CompanyRepository
 * @Description TODO
 * @Author YuChaoZheng
 * @Date 12/9/2019 7:03 PM
 * @Version 1.0
 **/
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

	@Transactional
	@Modifying()
	@Query(name = "setActiveForCompany", nativeQuery = true, value = "update company set companystatus = :active where companyname = :companyName")
	void setActiveForCompany(String companyName, String active);
}

