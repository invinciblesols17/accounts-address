package com.solstice.lab4.accountsaddress.services;

import com.solstice.lab4.accountsaddress.model.Account;
import com.solstice.lab4.accountsaddress.model.Address;
import com.solstice.lab4.accountsaddress.repository.AccountRepository;
import com.solstice.lab4.accountsaddress.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    public AddressService(AddressRepository addressRepository, AccountRepository accountRepository) {
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }

    public Iterable<Address> getAllByAccountId(Long id){
        return addressRepository.findByAccountId(id);
    }

    public Address getById(Long id, Long accountId){
        return addressRepository.getByIdAndAccountId(id, accountId);
    }

    public Address create(Address address, Long id) {
        Account account = accountRepository.findById(id).get();
        address.setAccount(account);
        return addressRepository.save(address);
    }

    public Address update(Long id, Long accountId, Address address){
        Account account = accountRepository.findById(accountId).get();
        Address addressById = addressRepository.findById(id).get();
        addressById.setAccount(account);
        addressById.setStreet(address.getStreet());
        addressById.setAptBuilding(address.getAptBuilding());
        addressById.setCity(address.getCity());
        addressById.setState(address.getState());
        addressById.setZip(address.getZip());
        addressById.setCountry(address.getCountry());
        return addressRepository.save(addressById);
    }

    public void delete(Long id, Long accountId){
        Address address = addressRepository.getByIdAndAccountId(id, accountId);
        if(address != null) {
            addressRepository.deleteById(address.getId());
        }
    }
}
