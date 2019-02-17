package pl.piotrnajecki.services;

import pl.piotrnajecki.domain.Contact;

import java.util.List;

/**
 * The Interface specifies all operation for ContactEntity
 */

public interface ContactService {
    public void save(Contact c);
    public void update(Contact c);

    public void delete(Integer contactId);
    public void delete(Integer[] contactIds);

    public Contact findById(Integer contactId);

    /**
     * This method returns all User Contact (user who is logged in).
     * @param userId
     * @return
     */

    public List<Contact> findUserContact(Integer userId);

    /**
     * The method search contact for user (userId) based on given free-criteria as (txt)
     * @param userId User ho is logged in
     * @param txt criteria used to search - free text search ciriteria
     * @return
     */

    public List<Contact> findUserContact(Integer userId, String txt);

}
