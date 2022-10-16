package com.seal.api.promech.repository;
import com.seal.api.promech.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    @Query(value = "SELECT * FROM Ticket WHERE Phone = :phone", nativeQuery = true)
    TicketEntity getByPhone(long phone);

    @Query(value = "SELECT * FROM Ticket WHERE Status = 1", nativeQuery = true)
    List<TicketEntity> getAll();

    @Modifying
    @Query(value = "INSERT INTO Ticket VALUES (:phone, :name, :password, 1, :description, :service)", nativeQuery = true)
    @Transactional
    int createTicket(long phone, String name, String password, String description, String service);

    @Modifying
    @Query(value ="UPDATE Ticket SET Phone = :phone, Name = :name, Password = :password, Description = :description, Service = :service WHERE TicketID = :ticketID", nativeQuery = true)
    @Transactional
    Integer updateTicket(int ticketID, long phone, String name, String password, String description, String service);


    @Modifying
    @Query(value = "UPDATE Ticket SET Status = 0 WHERE TicketID = :ticketID", nativeQuery = true)
    @Transactional
    Integer confirmTicket(int ticketID);
}
