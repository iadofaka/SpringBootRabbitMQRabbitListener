package mx.santander.listener.dao;

import mx.santander.listener.model.TycsServiceMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TycsServiceMessageDao extends CrudRepository<TycsServiceMessage, Long> {

    TycsServiceMessage findByApplicationId(String applicationId);

    TycsServiceMessage findByBuc(String buc);

    TycsServiceMessage findByTycVersion(String tycVersion);

}
