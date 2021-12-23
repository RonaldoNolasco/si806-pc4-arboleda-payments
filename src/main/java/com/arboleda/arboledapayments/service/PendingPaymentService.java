package com.arboleda.arboledapayments.service;


import com.arboleda.arboledapayments.dto.ListCompaniesDto;
import com.arboleda.arboledapayments.dto.ListPendingPaymentsDto;
import com.arboleda.arboledapayments.dto.ListServicesDto;
import com.arboleda.arboledapayments.model.Company;
import com.arboleda.arboledapayments.model.PendingPayment;
import com.arboleda.arboledapayments.model.Service;

import java.util.List;

public interface PendingPaymentService {

    public List<Company> listCompanies(ListCompaniesDto listCompanies);

    public List<Service> listServices(ListServicesDto listServicesDto);

    public List<PendingPayment> listPendingPayments(ListPendingPaymentsDto listPendingPayments);
}
