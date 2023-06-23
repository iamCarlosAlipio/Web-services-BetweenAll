package main.pe.com.betweenAll.services;

import main.pe.com.betweenAll.dtos.DTOAssistedTicketsSummary;
import main.pe.com.betweenAll.entities.Purchase;

import java.util.List;
public interface PurchaseService {
    public List<Purchase> listAll();
    public Purchase listById(Long id);
    public Purchase save(Purchase purchase);
    public void delete(Long id, boolean forced);

    public List<DTOAssistedTicketsSummary> listAssistedTicketsSummary();

}
