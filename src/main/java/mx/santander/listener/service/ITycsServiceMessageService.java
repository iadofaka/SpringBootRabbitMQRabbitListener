package mx.santander.listener.service;

import mx.santander.listener.model.TycsServiceMessage;

public interface ITycsServiceMessageService {


    void saveTycsServiceMessage(TycsServiceMessage tycsServiceMessage);

    TycsServiceMessage findTycsByBuc(String buc);

    TycsServiceMessage findTycsByTycVersion(String tycVersion);

    TycsServiceMessage findTycsByApplicationId(String applicationId);
}
