package com.arboleda.arboledapayments.service;

import com.arboleda.arboledapayments.dto.ListCompaniesDto;
import com.arboleda.arboledapayments.dto.ListPendingPaymentsDto;
import com.arboleda.arboledapayments.dto.ListServicesDto;
import com.arboleda.arboledapayments.model.Company;
import com.arboleda.arboledapayments.model.PendingPayment;
import com.arboleda.arboledapayments.model.Service;
import com.arboleda.arboledapayments.repository.CompanyRepository;
import com.arboleda.arboledapayments.repository.PendingPaymentRepository;
import com.arboleda.arboledapayments.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class PendingPaymentServiceImpl implements PendingPaymentService {
    @Autowired
    private PendingPaymentRepository pendingPaymentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Company> listCompanies(ListCompaniesDto listCompanies) {
        if (listCompanies.getCategory() == null && listCompanies.getPartialCompanyName() == null) {
            return companyRepository.findAll();
        }
        if (listCompanies.getCategory() != null & listCompanies.getPartialCompanyName() != null) {
            return companyRepository
                    .findByCategoryAndNameContaining(listCompanies.getCategory(), listCompanies.getPartialCompanyName());
        }
        if (listCompanies.getCategory() != null) {
            return companyRepository.findByCategory(listCompanies.getCategory());
        }
        // listCompanies.partialCompanyName != null
        return companyRepository.findByNameContaining(listCompanies.getPartialCompanyName());
    }

    public List<Service> listServices(ListServicesDto listServicesDto) {
        if (listServicesDto.getCurrency() == null) {
            return serviceRepository.findByCompanyId(listServicesDto.getCompanyId());
        }
        return serviceRepository.findByCompanyIdAndCurrency(listServicesDto.getCompanyId(), listServicesDto.getCurrency());
    }

    public List<PendingPayment> listPendingPayments(ListPendingPaymentsDto listPendingPayments) {
        return pendingPaymentRepository
                .findByServiceIdAndClientServiceCodeAndPaymentId(listPendingPayments.getServiceId(), listPendingPayments.getClientServiceCode(), null);
    }

}
