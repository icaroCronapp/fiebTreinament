package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Login {

public static final int TIMEOUT = 300;

/**
 *
 * @author Ícaro Antunes
 * @since 18/04/2024, 16:07:48
 *
 */
public static Var ehAdmin() throws Exception {
 return new Callable<Var>() {

   private Var ehAdm = Var.VAR_NULL;

   public Var call() throws Exception {
    ehAdm =
    cronapi.database.Operations.query(Var.valueOf("app.entity.UserRole"),Var.valueOf("select \n	u \nfrom \n	UserRole u  \nwhere \n	u.user.normalizedUserName = :userNormalizedUserName AND \n	u.role.builtIn = true"),Var.valueOf("userNormalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    if (
    cronapi.database.Operations.hasElement(ehAdm).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction(Var.valueOf("blockly.js.blockly.Periodo.mostraModal"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

