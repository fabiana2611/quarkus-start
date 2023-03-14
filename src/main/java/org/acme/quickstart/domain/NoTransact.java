package org.acme.quickstart.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class NoTransact {

    /*
     * @Transactional(REQUIRED) (default)
Starts a transaction if none was started; otherwise, stays with the existing one
@Transactional(REQUIRES_NEW)
Starts a transaction if none was started; if an existing one was started, suspends it
and starts a new one for the boundary of that method
@Transactional(MANDATORY)
Fails if no transaction was started; otherwise, works within the existing transaction
@Transactional(SUPPORTS)
If a transaction was started, joins it; otherwise, works with no transaction
@Transactional(NOT_SUPPORTED)
If a transaction was started, suspends it and works with no transaction for the
boundary of the method; otherwise, works with no transaction
@Transactional(NEVER)
If a transaction was started, raises an exception; otherwise, works with no
transaction
     */
    @Transactional(Transactional.TxType.NEVER)
    public String word() {
        return "Hi";
    }
}
