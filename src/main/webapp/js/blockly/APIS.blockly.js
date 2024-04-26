window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.APIS = window.blockly.js.blockly.APIS || {};

/**
 * @function consumoApi
 *
 *
 *
 *
 * @author Ícaro Antunes
 * @since 25/04/2024, 17:10:02
 *
 */
window.blockly.js.blockly.APIS.consumoApiArgs = [];
window.blockly.js.blockly.APIS.consumoApi = async function() {
 var item;
  //
  this.cronapi.util.getURLFromOthers('GET', 'application/json', 'https://servicodados.ibge.gov.br/api/v1/localidades/estados', null, null, async function(sender_item) {
      item = sender_item;
    //
    console.log(item);
  }.bind(this), async function(sender_item) {
      item = sender_item;
  }.bind(this));
}
