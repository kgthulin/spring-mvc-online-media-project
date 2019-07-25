package coder.daos;

import coder.models.Authority;
import org.springframework.stereotype.Component;

@Component
public interface AuthDao {
    void addAuth(Authority auth);
}
