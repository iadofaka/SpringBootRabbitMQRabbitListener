package mx.santander.listener.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EnableJpaAuditing
@Getter
@Setter
@RequiredArgsConstructor
public class TycsServiceMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String buc;
    private String applicationId;
    private String tycVersion;

    @Override
    public String toString() {
        return "TycsServiceMessage [buc=" + buc + ", applicationId=" + applicationId + ", tycVersion=" + tycVersion + "]";
    }
}
