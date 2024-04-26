package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Automatiza {

public static final int TIMEOUT = 300;

/**
 *
 * @param Consulta a Entidades<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 25/04/2024, 14:08:40
 *
 */
public static Var obterIdDoUsuarioLogado(@ParamMetaData(description = "Consulta_a_Entidades", id = "bf4902e3") Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
cronapi.util.Operations.getCurrentUserName()))));
   }
 }.call();
}

/**
 *
 * @param Consulta a Entidades<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 25/04/2024, 14:08:40
 *
 */
public static Var obterLoginDoUsuarioLogado(@ParamMetaData(description = "Consulta_a_Entidades", id = "bf4902e3") Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.normalizedUserName \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
cronapi.util.Operations.getCurrentUserName()))));
   }
 }.call();
}

}

