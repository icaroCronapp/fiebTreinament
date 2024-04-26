window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Periodo = window.blockly.js.blockly.Periodo || {};

/**
 * @function mostraModal
 *
 *
 *
 *
 * @author Ícaro Antunes
 * @since 18/04/2024, 16:10:43
 *
 */
window.blockly.js.blockly.Periodo.mostraModalArgs = [];
window.blockly.js.blockly.Periodo.mostraModal = async function() {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Periodo:verificaPer', async function(sender_item) {
      item = sender_item;
    //
    console.log(item);
    //
    if (!item) {
      //
      this.cronapi.notification.confirmDialogAlert('error', 'Você não tem um período ativo.', 'Cadastre um período.', this.cronapi.notification.buttonConfirmDialogAlert('true', 'Ok, entendi.', async function() {
        }.bind(this)));
    }
  }.bind(this));
}
