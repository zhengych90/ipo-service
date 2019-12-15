package com.smc.sba.controller;

import com.alibaba.fastjson.JSONObject;
import com.smc.sba.entity.CompanyEntity;
import com.smc.sba.entity.IPODetailEntity;
import com.smc.sba.service.CompanyService;
import com.smc.sba.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CompanyController
 * @Description TODO
 * @Author YuChaoZheng
 * @Date 12/9/2019 6:55 PM
 * @Version 1.0
 **/

@CrossOrigin
@RestController
@RequestMapping("/admin/manage/company")
public class CompanyController {


	@Autowired
	private CompanyService companyService;

	/**
	 * add company(带上“/admin/manage/company”)
	 * @param jsonObject
	 * @return
	 */
	@PostMapping
	public CommonResult newCompany(@RequestBody JSONObject jsonObject) {
		CompanyEntity companyDtl = jsonObject.getObject("company", CompanyEntity.class);
		IPODetailEntity ipoDetail = jsonObject.getObject("ipo", IPODetailEntity.class);
		return companyService.addCompany(companyDtl, ipoDetail);
	}

	/**
	 * put method 同上
	 * @param companyDtl
	 * @return
	 */
	@PutMapping
	public CommonResult updateCompany(
			@RequestBody CompanyEntity companyDtl) {
		return companyService.updateCompany(companyDtl);
	}

	/**
	 * active
	 * @param companyName
	 * @return
	 */
	@PostMapping("/active")
	public CommonResult activeCompany(@RequestParam("companyName") String companyName) {
		return companyService.setActiveForCompany(companyName, "1");
	}

	/**
	 * inactive
	 * @param companyName
	 * @return
	 */
	@PostMapping("/inactive")
	public CommonResult inactiveCompany(@RequestParam("companyName") String companyName) {
		return companyService.setActiveForCompany(companyName, "0");
	}

}
