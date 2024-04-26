package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ReservaMorador {

public static final int TIMEOUT = 300;

/**
 *
 * @param Consulta a Entidades<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 26/04/2024, 15:09:10
 *
 */
public static Var antesDeInserirReserva(@ParamMetaData(description = "Consulta_a_Entidades", id = "bbc04eee") Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   private Var dataOriginal = Var.VAR_NULL;
   private Var dataValidada = Var.VAR_NULL;
   private Var objetoVagaSelecionada = Var.VAR_NULL;
   private Var periodoAtivoNoMomento = Var.VAR_NULL;

   public Var call() throws Exception {
    dataOriginal =
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("data"));
    System.out.println(dataOriginal.getObjectAsString());
    dataValidada = Var.VAR_NULL;
    objetoVagaSelecionada =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    System.out.println(objetoVagaSelecionada.getObjectAsString());
    System.out.println(
    Var.valueOf("****************************").getObjectAsString());
    System.out.println(
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("vaga")).getObjectAsString());
    System.out.println(
    Var.valueOf("****************************").getObjectAsString());
    System.out.println(
    Var.valueOf("").getObjectAsString());
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(objetoVagaSelecionada,
    Var.valueOf("this[0].status")).equals(
    Var.valueOf("Fechada"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Vaga já está ocupada. Tente outra."));
    }
    periodoAtivoNoMomento =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    cronapi.database.Operations.hasElement(periodoAtivoNoMomento).getObjectAsBoolean()) {
        cronapi.database.Operations.updateField(Consulta_a_Entidades,
        Var.valueOf("periodo"),
        cronapi.database.Operations.getField(periodoAtivoNoMomento, Var.valueOf("this[0].periodo")));
    } else {
        cronapi.util.Operations.throwException(
        Var.valueOf("Não existe um período ativo. Contante um admin."));
    }
    if (
    cronapi.list.Operations.getFirst((
    cronapi.database.Operations.query(Var.valueOf("app.entity.Reserva"),Var.valueOf("select \n	r.ativo \nfrom \n	Reserva r  \nwhere \n	r.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName()))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Você só pode reservar uma vaga por vez."));
    } else {
        cronapi.database.Operations.updateField(Consulta_a_Entidades,
        Var.valueOf("ativo"),
        Var.VAR_TRUE);
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Consulta a Entidades<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 26/04/2024, 15:09:10
 *
 */
public static Var depoisDeInserir(@ParamMetaData(description = "Consulta_a_Entidades", id = "bbc04eee") Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   private Var objetoVagaReservada = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVagaReservada =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    cronapi.database.Operations.updateField(objetoVagaReservada,
    Var.valueOf("status"),
    Var.valueOf("Fechada"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

