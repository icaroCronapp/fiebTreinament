package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ValidacaoPeriodo {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade<app.entity.Periodo>
 *
 * @author Ícaro Antunes
 * @since 23/04/2024, 15:46:55
 *
 */
public static Var antesDeInserirPeriodo(@ParamMetaData(description = "Entidade", id = "f7f3b7c8") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var periodoGerado = Var.VAR_NULL;
   private Var consultaPeriodo = Var.VAR_NULL;
   private Var objetoAtivo = Var.VAR_NULL;
   private Var dataEntre = Var.VAR_NULL;

   public Var call() throws Exception {
    // Validando para que as datas tenha meses iguais sempre
    if (
    Var.valueOf(!
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataInicial"))).equals(
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataFinal"))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("O mês das datas precisam ser iguais"));
    }
    periodoGerado =
    Var.VAR_NULL;
    if (
    Var.valueOf(
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("periodo")).equals(
    Var.valueOf("1"))).getObjectAsBoolean() ||
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("periodo")).equals(
    Var.valueOf("2"))).getObjectAsBoolean()).getObjectAsBoolean()) {
        periodoGerado =
        Var.valueOf(
        cronapi.object.Operations.getObjectField(Entidade,
        Var.valueOf("periodo")).getObjectAsString() +
        Var.valueOf("/").getObjectAsString() +
        cronapi.conversion.Operations.toString(
        cronapi.dateTime.Operations.getYear(
        cronapi.object.Operations.getObjectField(Entidade,
        Var.valueOf("dataFinal")))).getObjectAsString());
        cronapi.database.Operations.updateField(Entidade,
        Var.valueOf("periodo"), periodoGerado);
    }
    consultaPeriodo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.periodo = :periodo"),Var.valueOf("periodo",periodoGerado));
    if (
    cronapi.database.Operations.hasElement(consultaPeriodo).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("Já existe o períodogjhgjbhjbjh ").getObjectAsString() +
        periodoGerado.getObjectAsString()));
    }
    objetoAtivo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(objetoAtivo,
    Var.valueOf("this[0].ativo")).getObjectAsBoolean() &&
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("ativo")).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("Apenas um período pode ser ativo por vez. O período  ").getObjectAsString() +
        cronapi.database.Operations.getField(objetoAtivo,
        Var.valueOf("this[0].periodo")).getObjectAsString() +
        Var.valueOf(" já está ativo.").getObjectAsString()));
    }
    dataEntre =
    cronapi.database.Operations.query(Var.valueOf("app"),Var.valueOf("SELECT * \nFROM Periodo P \nWHERE :dataInicial BETWEEN p.dataInicial AND p.dataFinal\n   OR :dataFinal BETWEEN p.dataInicial  AND p.dataFinal;"),Var.valueOf("dataInicial",
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataInicial"))),Var.valueOf("dataFinal",
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataFinal"))));
    if (
    cronapi.database.Operations.hasElement(dataEntre).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("Data já está sendo usada em outro período.").getObjectAsString()));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Entidade<app.entity.Periodo>
 *
 * @author Ícaro Antunes
 * @since 23/04/2024, 15:46:55
 *
 */
public static Var depoisDeInserir(@ParamMetaData(description = "Entidade", id = "f7f3b7c8") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var periodoGerado = Var.VAR_NULL;
   private Var consultaPeriodo = Var.VAR_NULL;
   private Var objetoAtivo = Var.VAR_NULL;
   private Var dataEntre = Var.VAR_NULL;

   public Var call() throws Exception {
    return Var.VAR_NULL;
   }
 }.call();
}

}

