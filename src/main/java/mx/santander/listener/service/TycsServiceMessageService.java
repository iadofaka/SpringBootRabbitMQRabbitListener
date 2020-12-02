package mx.santander.listener.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.santander.listener.dao.TycsServiceMessageDao;
import mx.santander.listener.model.TycsServiceMessage;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TycsServiceMessageService implements ITycsServiceMessageService {

    private final TycsServiceMessageDao tycsServiceMessageDao;

    @Override
    public void saveTycsServiceMessage(TycsServiceMessage tycsServiceMessage) {
        log.info("Send data informatiomn to database: {}", tycsServiceMessage.toString());
        tycsServiceMessageDao.save(tycsServiceMessage);
    }

    @Override
    public TycsServiceMessage findTycsByBuc(String buc) {
        log.info("find information by buc: {}", buc);
        return tycsServiceMessageDao.findByBuc(buc);
    }

    @Override
    public TycsServiceMessage findTycsByTycVersion(String tycVersion) {
        return tycsServiceMessageDao.findByTycVersion(tycVersion);
    }

    @Override
    public TycsServiceMessage findTycsByApplicationId(String applicationId) {
        return tycsServiceMessageDao.findByApplicationId(applicationId);
    }
}
