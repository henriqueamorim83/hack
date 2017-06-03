/**
 * @author henrique amorim
 * Essa classe sera usada no sistema para implementa��o de javascript
 *
 */


$(document).ready(function() {
	//relógio
	
	 // Variáveis de Mês e Dias
    var monthNames = [ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" ]; 
    var dayNames= ["Dom","Seg","Ter","Qua","Qui","Sex","Sáb"]
    
    // Pegar Data/Hora
    var newDate = new Date();
    // Extrair data atual do Objeto
    newDate.setDate(newDate.getDate());
    // Saida de Dia, Data, Mês e Ano
    $('#Date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());
    
    setInterval( function() {

        var seconds = new Date().getSeconds();
        // Adiciona um zero, quando necessário
        $("#sec").html(( seconds < 10 ? "0" : "" ) + seconds);
        },1000);
        
    setInterval( function() {

        var minutes = new Date().getMinutes();
        // Adiciona um zero, quando necessário
        $("#min").html(( minutes < 10 ? "0" : "" ) + minutes);
        },1000);
        
    setInterval( function() {

        var hours = new Date().getHours();
        // Adiciona um zero, quando necessário
        $("#hours").html(( hours < 10 ? "0" : "" ) + hours);
        }, 1000);
	
	
	//aqui bloqueia a tecla voltar de navegação
	//window.history.forward(1);
	
	//desativa as teclas f5 e control + f5 e varias outras teclas do navegador
	/**'a', 'n', 'c', 'x', 'v', 'j'*/
    document.onkeydown = function () { 
        switch (event.keyCode) {
        	case 16 : 
	            if (event.ctrlKey) {  
	               event.returnValue = false;
	              event.keyCode = 0;             
	              return false;
	            }
        	case 65 : 
	            if (event.ctrlKey) {  
	               event.returnValue = false;
	              event.keyCode = 0;             
	              return false;
	            }
        	case 67 : 
	            if (event.ctrlKey) {  
	               event.returnValue = false;
	              event.keyCode = 0;             
	              return false;
	            }
        	case 73 : 
                if (event.ctrlKey) {  
                   event.returnValue = false;
                  event.keyCode = 0;             
                  return false;
                }
        	case 74 : 
            if (event.ctrlKey) {  
               event.returnValue = false;
              event.keyCode = 0;             
              return false;
            }
        	case 76 : 
                if (event.ctrlKey) {  
                   event.returnValue = false;
                  event.keyCode = 0;             
                  return false;
                }
        	case 82 : 
                if (event.ctrlKey) {  
                   event.returnValue = false;
                  event.keyCode = 0;             
                  return false;
                }
          case 116 :   if (event.ctrlKey) {  
             event.returnValue = false;
             event.keyCode = 0;           
             return false;             
          	}
           case 82 : 
             if (event.ctrlKey) {  
                event.returnValue = false;
               event.keyCode = 0;             
               return false;
             }
      }
  } 
	/**
	*Aqui verifica os tipos de navegadores que irão 
	*/
	var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
    // Opera 8.0+ (UA detection to detect Blink/v8-powered Opera)
	var isFirefox = typeof InstallTrigger !== 'undefined';   // Firefox 1.0+
	var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
    // At least Safari 3+: "[object HTMLElementConstructor]"
	var isChrome = !!window.chrome && !isOpera;              // Chrome 1+
	var isIE = /*@cc_on!@*/false || !!document.documentMode; // At least IE
	
	//alert("Opera : "+ isOpera+ "  firefox : "+ isFirefox + " Chrome : "+ isChrome + " IE " + isIE);
	//alert(window.chrome.version);	
	
	/*
	if ($.browser.msie) {
		
		
		if(parseInt($.browser.version) == 11){
	         // Para IE8
	    	alert("ie 11");
	       //  $("html").addClass("ie8");
	    } else if(parseInt($.browser.version) == 8){
	         // Para IE8
	    	alert("ie 8");
	       //  $("html").addClass("ie8");
	    } else if(parseInt($.browser.version) == 7){
	         // Para IE7
	         $("html").addClass("ie7");
	    } else if(parseInt($.browser.version) == 6){
	         // Para IE6
	         $("html").addClass("ie6");
	    }
	}*/

	  if(navigator.appVersion.indexOf("MSIE")!= -1){
		    var temp = navigator.appVersion.split("MSIE");
		    var versao = parseFloat(temp[1]);
		//    window.alert("Você está usando a versão " + versao + " do IE.");
		  }
		  else{
		//    window.alert("Você não está usando IE");
		  }
	
	
	
	 if(navigator.userAgent.indexOf("Firefox")!= -1){
		    var temp = navigator.userAgent.indexOf("Firefox") + 8;
		    var versao = navigator.userAgent.substring(temp, temp + 6);
		//    alert("Você está usando  Firefox e a versão " + versao );
		  }
		  else{
		//    window.alert("Você não está usando Firefox");
		  }
	 if(navigator.userAgent.indexOf("Chrome")!= -1){
		    var temp = navigator.userAgent.indexOf("Chrome") + 7;
		    var versao = navigator.userAgent.substring(temp, temp + 13);
		//    alert("Você está usando Chrome e a versão " + versao );
		  }
		  else{
		//    window.alert("Você não está usando Chrome");
		  }
	
	$(document).keypress(function(e){
		
		 if(e.wich == 27 || e.keyCode == 27 || e.charCode == 27){
				PF('fecharDialogEsc').start();
				
				
			}
		//Aqui é par que o enter funcione como tab....
		 //mas não esta funcionando..
		 /*var key =e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		     if(key == 13) {
		         e.preventDefault();
		         var inputs = $(this).closest('form').find(':input:visible');
		         inputs.eq( inputs.index(this)+ 1 ).focus();
		        
		     }*/
		     
		  /*  
		   * TABULAÇÃO COM ENTER. TEM IMPACTO SOBRE OS CAMPOS QUE PRECISAM DE DIALOG
		   * */ 
		  /*   textboxes = $("input, select, textarea");  
			  
		 	if ($.browser.mozilla) {  
		 	    $(textboxes).keypress (checkForEnter);  
		 	} else {  
		 	    $(textboxes).keydown (checkForEnter);  
		 	} */
		 	
		 	
		});
	
	
	/* $(document).keypress(function(e){
			
		 if(e.wich == 6 || e.keyCode == 6){
				alert('A tecla ENTER foi pressionadas');
			}
		  });
	 	document.onkeydown = function(evt) {
		    evt = evt || window.event;
		    if (evt.keyCode == 27) {
		        alert("Escape");
		    }
		};*/
	
	
	var teclas_permitidas = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

	$(document).on("keypress", ".JSsomenteNumeros", function(event) {
		if (jQuery.inArray(event.keyCode, teclas_permitidas) != -1) { return true; }	
		
		var valor = String.fromCharCode(!event.charCode ? event.which : event.charCode);
		var regex = /[^0-9]/i;
				
		if(regex.test(valor)) {
			event.preventDefault();
			return false;
		}
	});
	
	var teclas_permitidas = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,','];

	$(document).on("keypress", ".JSsomentePercentual", function(event) {
		if (jQuery.inArray(event.keyCode, teclas_permitidas) != -1) { return true; }	
		
		var valor = String.fromCharCode(!event.charCode ? event.which : event.charCode);
		var regex = /[^0, 1, 2, 3, 4, 5, 6, 7, 8, 9,',']/g;
				
		if(regex.test(valor)) {
			event.preventDefault();
			return false;
		}
	});
	
	
	/* Control c + control v proibe nessa função
	$(':input').on("drop", function() {
		return false;
	});*/

	$(document).on("focus blur", ".JSData", function() {
		var element = $(this).find('input:first');
		element.mask('99/99/9999', {placeholder:'_'});
		VerificaData(element[0]);
	});

	$(document).on("keyup", ".JSvalorMoeda", function() {
		JEffects.masks.formataMoeda(this);

	});
	$(document).on("blur", ".JSvalorMoeda", function() {
		if(isNaN($(this).val().replace(",","").replace(".",""))){
			$(this).val("");
		}
	});
	
	$(document).on("keyup", ".JSformatarQuatroCasas", function() {
		JEffects.masks.formatarQuatroCasas(this);

	});
	$(document).on("blur", ".JSformatarQuatroCasas", function() {
		if(isNaN($(this).val().replace(",","").replace(".",""))){
			$(this).val("");
		}
	});
	
	$(document).on("keyup", ".JSPercentual", function() {
		JEffects.masks.percentual(this);

	});
	$(document).on("blur", ".JSPercentual", function() {
		if(isNaN($(this).val().replace(",","").replace(".",""))){
			$(this).val("");
		}
	});
	
	
	/**
	 * teclar esc em qualquer input para fechar os modais*/
	$(document).keypress("focus blur", ":input", function(e) {
		
		
		 if(e.wich == 27 || e.keyCode == 27 || e.charCode == 27){
			//	PF('fecharDialog').start();
			//	PF('dialogFiltroListagem').hide();
			//    PF('escolherBusca').hide();
			//	PF('consultarNota').hide();
			//	alert("henrique");
			}
		
	
	return false;
});

	

	/**
	 * Proibe que seja feito drop de textos
	 */
	$(document).on("drop", ":input", function() {
		return false;
	});

	$(document).on("cut copy paste", ".notPaste", function(e) {
		e.preventDefault();
	});
	
	display();

	


});

//caso precise chamar uma subpagina
function display(){

		//  $("#conteudo").load("/ripe/pages/aniversariante/listaAniversariante.jsf");

}

function display(pagina){
	//$("#display").load(pagina);
	//if(pagina!=null&& pagina.length >0){
	//$("#sumir").css('display','none');
	//}
}


/*
* Forca uma mascara para os componentes (quando digitaveis) do tipo p:calendar
*/
$(document).on("focus", ".JSData", function() {
	$(this).find('input:first').mask('99/99/9999', {placeholder:'_'});
});


// Limitacao de campos utilizados no inputtextarea
function limitarTamanho(campo, limite) {
	if ((limite - campo.value.length) <= 0) {
		campo.value = campo.value.substr(0, limite);
	}
}
function validarNumeroDecimal(campo) {
	var valor = trim(campo.value);
	var test = /^[-+]?[0-9]+(\.[0-9]+)?$/.test(valor);
	if (!test) {
		campo.value = '';
	}
	return test;
}
function trim(str) {
	return str.replace(/^\s+|\s+$/g, "");
}

// Limita��o de valores por meio de um range
function limitarValor(valorAtual, valorMinimo, valorMaximo) {

	if (valorAtual.value < valorMinimo) {
		valorAtual.value = valorMinimo;
	} else if (valorAtual.value > valorMaximo) {
		valorAtual.value = valorMaximo;
	}

}

// Fun��o para mascarar um campo s� num�rico
function SomenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58)) {
		return true;
	} else {
		if (tecla == 8 || tecla == 0) {
			return true;
		} else {
			return false;
		}
	}
}

function somente_numero(campo) {
	var digits = "0123456789";
	var campo_temp;
	for ( var i = 0; i < campo.value.length; i++) {
		campo_temp = campo.value.substring(i, i + 1);
		if (digits.indexOf(campo_temp) == -1) {
			campo.value = campo.value.substring(0, i);
		}
	}
}

function removerCaracteresNaoPermitidos(permitidos, campo) {
	var campo_temp;
	for ( var i = 0; i < campo.value.length; i++) {
		campo_temp = campo.value.substring(i, i + 1);
		if (permitidos.indexOf(campo_temp) == -1) {
			campo.value = campo.value.substring(0, i);
		}
	}
}

function validarHora(campo) {

	var h = campo.value.substring(0, 2);
	var m = campo.value.substring(3, 5);
	var s = campo.value.substring(6, 8);

	if (h > 23){h = 23;}
	if (m > 59){m = 59;}
	if (s > 59){s = 59;}

	campo.value = h + ':' + m + ':' + s;
}

function apenasLetras(campo) {

	removerCaracteresNaoPermitidos(
			" 'ABCDEFGHIJLMNOPQRSTUVXZKWYabcdefghijlmnopqrstuvxzkwy���������������������������ݟ�����������������������������������������������",
			campo);

}

function decimal(campo){
	var valor = campo.value;
	var numero = valor.toFixed(3);
	campo = numero;
	
}

function numeroDecimal(e, campo) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58) || (tecla > 95 && tecla < 106)) {
		return true;
	} else {
		if (tecla == 8 || tecla == 9 || tecla == 0 || tecla == 37
				|| tecla == 39 || tecla == 46) {
			return true;
		}
		if (tecla == 194 || tecla == 190) {
			var pos = campo.value.indexOf("\.");
			if ((pos == -3)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}

function DecimalValidate(campo) {
	// regular expression
	var rgexp = new RegExp("^\d*([,]\d{2})?$");
	var input = campo.value;

	if (input.match(rgexp)) {
		return true;
	} else {
		return false;
	}
}

function validarNumeroDecimal(campo) {
	var valor = trim(campo.value);
	var test = /^[-+]?[0-9]+(\.[0-9]+)?$/.test(valor);
	if (!test) {
		campo.value = '';
	}
	return test;
}

function trim(str) {
	return str.replace(/^\s+|\s+$/g, "");
}

// Fun��o para deixar todas as letras mai�sculas
function letraMaiuscula(campo) {
	campo.value = campo.value.toUpperCase();
}

function VerificaData(campo, cData) {
	var data = cData;
	var tam = data.length;
	if (tam != 10) {
		campo.value = "";
		alert("\"" + valor + "\" n�o � uma data v�lida.");
		return false;
	}
	var dia = data.substr(0, 2);
	var mes = data.substr(3, 2);
	var ano = data.substr(6, 4);
	if (ano < 1600) {
		campo.value = "";
		return false;
	}

	if (mes > 12 || mes < 1) {
		campo.value = "";
		return false;
	}

	switch (mes) {
	case '01':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '02':
		if (naoBissexto(ano)) {
			if (dia <= 29) {
				return (true);
			}
		} else {
			if (dia <= 28) {
				return (true);
			}
		}
		break;
	case '03':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '04':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '05':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '06':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '07':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '08':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '09':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '10':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '11':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '12':
		if (dia <= 31) {
			return (true);
		}
		break;
	}
	campo.value = "";
	return false;
}

function formatoData(campo) {

	var digits = "0123456789/";
	var campo_temp;

	for ( var i = 0; i < campo.value.length; i++) {
		campo_temp = campo.value.substring(i, i + 1);

		if (digits.indexOf(campo_temp) == -1) {
			campo.value = "";
		}
	}

	return campo;
}

// JEffects.js
// cont�m todos os efeitos do site

var JEffects = {
	handleEnter : function(field, event) {
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
		if (keyCode == 13) {
			var i;
			for (i = 0; i < field.form.elements.length; i++) {
				if (field == field.form.elements[i]) {
					break;
				}
			}
			i = (i + 1) % field.form.elements.length;
			field.form.elements[i].focus();
			return false;
		} else {
			return true;
		}
	},
	msgAlert : function(titulo, msg) {
		$('body')
				.after(
						'<div style="height: 200px; min-height: 109px; width: auto;" class="ui-dialog-content ui-widget-content" id="dialog"><p id="msg-erro-content"></p></div>');
		$('#msg-erro-content').html(msg);
		$('#dialog').dialog({
			title : titulo,
			bgiframe : true,
			modal : true,
			resizable : false,
			draggable : false,
			close : function(ev, ui) {
				$('#dialog').remove();
			},
			buttons : {
				"OK" : function() {
					$(this).dialog("close");
				}
			}
		});
	},
	print : function(content) {
		w = window.open();
		w.document.write("<html><body>" + content + "</body></html>");
		w.print();
		w.close();
	}
}

JEffects.masks = {
	numeros : function(obj) {
		var objValue = obj.value;
		while (/[^0-9]/.test(objValue)){objValue = objValue.replace(/[^0-9]/, '');}
		obj.value = objValue;
	},
	hora : function(vHora) {
		hora = vHora.value;
		nHora = hora.replace(/:/, '');
		nHora = nHora.replace(/[^0-9]/, '');
		var h = nHora.substring(0, 2);
		var m = nHora.substring(2, 4);
		// var s = nHora.substring(4, 6);
		if (nHora.length == 1){vHora.value = h;}
		// if (nHora.length == 2)
		// vHora.value = h + ":";
		if (nHora.length >= 3){vHora.value = h + ":" + m;
/*
 * if (nHora.length == 4) vHora.value = h + ":" + m + ":"; if
 * (nHora.length == 5) vHora.value = h + ":" + m + ":" + s; if
 * (nHora.length == 6) vHora.value = h + ":" + m + ":" + s;
 */}
	},
	data : function(obj) {
		var pass = obj.value;
		var expr = /[0123456789]/;
		for (i = 0; i < pass.length; i++) {
			// charAt -> retorna o caractere posicionado no �ndice especificado
			var lchar = obj.value.charAt(i);
			var nchar = obj.value.charAt(i + 1);
			if (i == 0) {
				// search -> retorna um valor inteiro, indicando a posi�ao do
				// inicio da primeira
				// ocorrencia de expReg dentro de instStr. Se nenhuma ocorrencia
				// for encontrada o m�todo retornara -1
				// instStr.search(expReg);
				if ((lchar.search(expr) != 0) || (lchar > 3)) {
					obj.value = "";
				}
			} else if (i == 1) {
				if (lchar.search(expr) != 0) {
					// substring(indice1,indice2)
					// indice1, indice2 -> ser� usado para delimitar a string
					var tst1 = obj.value.substring(0, (i));
					obj.value = tst1;
					continue;
				}
				if ((nchar != '/') && (nchar != '')) {
					var tst1 = obj.value.substring(0, (i) + 1);
					if (nchar.search(expr) != 0) {
						var tst2 = obj.value.substring(i + 2, pass.length);
					} else {
						var tst2 = obj.value.substring(i + 1, pass.length);
					}
					obj.value = tst1 + '/' + tst2;
				}
			} else if (i == 4) {
				if (lchar.search(expr) != 0) {
					var tst1 = obj.value.substring(0, (i));
					obj.value = tst1;
					continue;
				}
				if ((nchar != '/') && (nchar != '')) {
					var tst1 = obj.value.substring(0, (i) + 1);
					if (nchar.search(expr) != 0) {
						var tst2 = obj.value.substring(i + 2, pass.length);
					} else {
						var tst2 = obj.value.substring(i + 1, pass.length);
					}
					obj.value = tst1 + '/' + tst2;
				}
			}
			if (i >= 6) {
				if (lchar.search(expr) != 0) {
					var tst1 = obj.value.substring(0, (i));
					obj.value = tst1;
				}
			}
		}
		if (pass.length > 10){obj.value = obj.value.substring(0, 10);}
		return true;
	},
	telefone : function(objTelefone) {
		telefone = objTelefone.value;
		fTelefone = telefone.replace(/[^0-9]/, '');
		fTelefone = fTelefone.replace(/ /, '');
		fTelefone = fTelefone.replace(/\(/, '');
		fTelefone = fTelefone.replace(/\)/, '');
		if (fTelefone.length > 7) {
			var ddd = fTelefone.substring(0, 2);
			var resto = fTelefone.substring(2, 11);
			objTelefone.value = "(" + ddd + ") " + resto;
		} else {
			objTelefone.value = fTelefone;
		}
	},
	valor : function(obj) {
		var valor = obj.value;
		while (/[^0-9]/.test(valor)) {
			valor = valor.replace(/[^0-9]/, '');
		}
		decimal = valor.substring((valor.length - 2), valor.length);
		if (valor.length == 3){inteiro = valor.substring(0, 1);} else {inteiro = valor.substring(0, (valor.length - 2));}
		if (valor.length <= 2){obj.value = valor;}
		if (valor.length > 2) {
			var tamInteiro = inteiro.length;

			obj.value = inteiro + "," + decimal;
		}
	},
	percentual : function(obj) {
		var valor = obj.value;
		while (/[^0-9]/.test(valor)) {
			valor = valor.replace(/[^0-9]/, '');
		}
		decimal = valor.substring((valor.length - 2), valor.length);
		if (valor.length == 4){inteiro = valor.substring(0, 2);} else {inteiro = valor.substring(0, (valor.length - 2));}
		if (valor.length <= 2){obj.value = valor;}
		if (valor.length > 2) {
			var tamInteiro = inteiro.length;

			obj.value = inteiro + "," + decimal;
		}
	},
	percentual2 : function(obj) {
		var valor = obj.value;
		while (/[^0-9]/.test(valor)) {
			valor = valor.replace(/[^0-9]/, '');
		}
		decimal = valor.substring((valor.length - 2), valor.length);
		if (valor.length == 3){inteiro = valor.substring(0, 2);} else {inteiro = valor.substring(0, (valor.length - 2));}
		if (valor.length <= 3){obj.value = valor;}
		if (valor.length > 2) {
			var tamInteiro = inteiro.length;

			obj.value = inteiro + "," + decimal;
		}
	},

	formataMoeda : function(objTextBox) {
		var caract = /[^0-9]/;
		var valor = objTextBox.value;
		while (caract.test(valor)){valor = valor.replace(caract, '');}
		caract = /^00/;
		while (caract.test(valor)){valor = valor.replace(caract, '');}
		var str = '';
		if (valor.length == 1){str = "0.0" + valor;}
		if (valor.length == 2){str = "0." + valor;}
		if (valor.length > 2) {
			var div;
			if(valor.substring(0,1) == 0){
				valor = valor.substring(1, valor.length);
			}
			var decimal = valor.substr(valor.length - 2, 2);
			var inteiro = valor.substring(0, valor.length - 2);
			if (inteiro.length <= 3) {
				str = inteiro + "," + decimal;
			} else {
				i = 1;
				var resto = inteiro.length % 3;
				var tam = inteiro.length - resto;
				div = tam / 3;
				var textFormated = '';
				var init = resto;
				if (resto > 0){textFormated = inteiro.substr(0, resto) + ".";}
				while (div != 0) {
					textFormated = textFormated + inteiro.substr(init, 3) + ".";
					init = init + 3;
					div--;
				}
				str = textFormated.replace(/\.$/, str) + "," + decimal;
			}
		}
		objTextBox.value = str;
	},
	
	formatarQuatroCasas : function(objTextBox) {
		var caract = /[^0-9]/;
		var valor = objTextBox.value;
		while (caract.test(valor)){valor = valor.replace(caract, '');}
		caract = /^00/;
		while (caract.test(valor)){valor = valor.replace(caract, '');}
		var str = '';
		if (valor.length == 1){str = "0.0" + valor;}
		if (valor.length == 2){str = "0." + valor;}
		if (valor.length == 3){str = "0." + valor;}
		if (valor.length == 4){//str = "0." + valor;
			if(valor.substring(0,1)=="0"){
				valor=valor.substring(1,valor.length);
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);
			}else{
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);
			}
		}
		if (valor.length == 5){
			if(valor.substring(0,1)=="0"){
				valor=valor.substring(1,valor.length);				
			}if(valor.substring(0,1)==0 &&  valor.substring(1,2)>0){
				valor=valor.substring(1,valor.length);			
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			}if(valor.substring(0,1)>0 &&  valor.substring(0,2)<10){
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			} if(valor.substring(0,2)>9){
				str =valor.substring(0,2)+"."+ valor.substring(2,valor.length);		
			}
			if(valor.substring(0,1)>0 &&  valor.substring(1,2)==0){
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			}
			if(valor.substring(0,1)>0 &&  valor.substring(1,2)>0){
				str =valor.substring(0,2)+"."+ valor.substring(2,valor.length);		
			}	
		}
		if (valor.length == 6){
			if(valor.substring(0,1)=="0"){
				valor=valor.substring(1,valor.length);				
			}if(valor.substring(0,1)==0 &&  valor.substring(1,2)>0){
				valor=valor.substring(1,valor.length);			
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			}if(valor.substring(0,1)>0 &&  valor.substring(0,2)<10){
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			} if(valor.substring(0,2)>9){
				str =valor.substring(0,2)+"."+ valor.substring(2,valor.length);		
			}
			if(valor.substring(0,1)>0 &&  valor.substring(1,2)==0){
			//	str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			}
			if(valor.substring(0,1)>0 &&  valor.substring(1,2)>0){
				str =valor.substring(0,2)+"."+ valor.substring(2,valor.length);		
			}	
			
		}
		
		if (valor.length == 7){
			if(valor.substring(0,1)=="0"){
				valor=valor.substring(1,valor.length);				
			}if(valor.substring(0,1)==0 &&  valor.substring(1,2)>0){
				valor=valor.substring(1,valor.length);			
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			}if(valor.substring(0,1)>0 &&  valor.substring(0,2)<10){
				str =valor.substring(0,1)+"."+ valor.substring(1,valor.length);		
			} if(valor.substring(0,2)>9){
				str =valor.substring(0,2)+"."+ valor.substring(2,valor.length);		
			}
			if(valor.substring(0,1)>0 &&  valor.substring(1,2)>0){
				str =valor.substring(0,2)+"."+ valor.substring(2,valor.length);		
			}
		}
		if (valor.length > 7) {
			var div;
			if(valor.substring(0,1) == 0){
				valor = valor.substring(1, valor.length);
			}
			var decimal = valor.substr(valor.length - 2, 2);
			var inteiro = valor.substring(0, valor.length - 2);
			if (inteiro.length <= 3) {
				str = inteiro + "." + decimal;
			} else {
				i = 1;
				var resto = inteiro.length % 3;
				var tam = inteiro.length - resto;
				div = tam / 3;
				var textFormated = '';
				var init = resto;
				if (resto > 0){textFormated = inteiro.substr(0, resto) + ".";}
				while (div != 0) {
					textFormated = textFormated + inteiro.substr(init, 3) + ".";
					init = init + 3;
					div--;
				}
				str = textFormated.replace(/\.$/, str) + "." + decimal;
			}
		}
		objTextBox.value = str;
	},
	
	
	cnpj : function(Campo, teclapres) {
		if (window.event) {
			var tecla = teclapres.keyCode;
		} else {
			tecla = teclapres.which;
		}
		var vr = new String(Campo.value);
		vr = vr.replace(".", "");
		vr = vr.replace(".", "");
		vr = vr.replace("/", "");
		vr = vr.replace("-", "");

		tam = vr.length + 1;

		if (tecla != 9 && tecla != 8) {
			if (tam > 2 && tam < 6){Campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3);}
			if (tam >= 6 && tam < 9){Campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.'
					+ vr.substr(5, 3);}
			if (tam >= 9 && tam < 13){Campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.'
					+ vr.substr(5, 3) + '/' + vr.substr(8, 4);}
			if (tam >= 13){Campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.'
					+ vr.substr(5, 3) + '/' + vr.substr(8, 4) + '-'
					+ vr.substr(12, 2);}
		}
	},
	inscricaoEstadual : function(obj) {
		var txt = obj.value;
		while (/[^0-9]/.test(txt)){txt = txt.replace(/[^0-9]/, '');}
		var c1 = txt.substr(0, 2);
		var c2 = txt.substr(2, 3);
		var c3 = txt.substr(5, 3);
		// var c4 = ;
		if (txt.length > 0 && txt.length <= 2){obj.value = c1;}
		if (txt.length >= 3 && txt.length <= 5){obj.value = c1 + "." + c2;}
		if (txt.length >= 6 && txt.length <= 8){obj.value = c1 + "." + c2 + "." + c3;}
		if (txt.length >= 9) {
			obj.value = c1 + "." + c2 + "." + c3 + "-" + txt.substr(8, 1);
		}
	},
	registroJucepa : function(obj) {
		var txt = obj.value;
		for (i = 0; i < txt.length + 1; i++) {txt = txt.replace(/[^0-9]/, '');}
		obj.value = txt;
	},
	cep : function(obj) {
		var txt = obj.value;
		for (i = 0; i < txt.length + 1; i++) {txt = txt.replace(/[^0-9]/, '');}
		var c1 = txt.substr(0, 2);
		var c2 = txt.substr(2, 3);
		var c3 = txt.substr(5, 3);
		if (txt.length > 0 && txt.length <= 2){obj.value = c1;}
		if (txt.length >= 3 && txt.length <= 5){obj.value = c1 + "." + c2;}
		if (txt.length >= 6){obj.value = c1 + "." + c2 + "-" + c3;}
	},
	cpf : function(campo, teclapres) {
		var vr = campo.value;
		while (/[^0-9]/.test(vr)){vr = vr.replace(/[^0-9]/, '')}
		var str = "";
		var t = vr.length;
		if (t >= 1 && t <= 3){str = vr.substr(0, 3);}
		if (t >= 4 && t <= 6){str = vr.substr(0, 3) + "." + vr.substr(3, 3);}
		if (t >= 7 && t <= 9){str = vr.substr(0, 3) + "." + vr.substr(3, 3) + "."
				+ vr.substr(6, 3);}
		if (t >= 10){str = vr.substr(0, 3) + "." + vr.substr(3, 3) + "."
				+ vr.substr(6, 3) + "-" + vr.substr(9, 2);}
		campo.value = str;
	},
	codigoNaturezaJuridica : function(objTextBox) {
		var str = objTextBox.value;
		while (/[a-zA-Z]/.test(str)){str = str.replace(/[a-zA-Z]/, "");}
		str = str.replace(/[a-zA-Z]/, "");
		objTextBox.value = str;
	},
	numericaMilhar : function(objTextBox) {
		var str = objTextBox.value;
		var caract = /[^0-9\.]/;
		while (caract.test(str)){str = str.replace(caract, "");}
		str = str.replace(caract, "");
		objTextBox.value = str;
	},
	numericaPorcentagem : function(objTextBox) {
		var str = objTextBox.value;
		var caract = /[^0-9]/;
		while (caract.test(str)){str = str.replace(caract, "");}
		str = str.replace(caract, "");
		if (str.length > 5){str = str.substr(0, str.length - (str.length - 5));}
		if (str.length < 2){objTextBox.value = str;}
		if (str.length == 2){objTextBox.value = str.substr(0, 1) + ","
				+ str.substr(str.length - 1, 1);}
		if (str.length == 3){objTextBox.value = str.substr(0, 1) + ","
				+ str.substr(str.length - 2, 2);}
		if (str.length == 4){objTextBox.value = str.substr(0, 2) + ","
				+ str.substr(str.length - 2, 2);}
		if (str.length == 5){objTextBox.value = str.substr(0, 3) + ","
				+ str.substr(str.length - 2, 2);}
	},
	peso : function(objTextBox) {
		
		var str = objTextBox.value;
		var caract = /[^0-9]/;
		while (caract.test(str)){str = str.replace(caract, "");}
		str = str.replace(caract, "");
		if (str.length > 6){
			str = str.substr(0, str.length - (str.length - 6));
			}
		if (str.length < 2){
			objTextBox.value = str;
			}
		if (str.length == 2){
			objTextBox.value =  "."+ str.substr(0, 2);
			}
		if (str.length == 3){
			objTextBox.value =  "."+ str.substr(str.length - 3, 3);
			}
		if (str.length == 4){
			objTextBox.value = str.substr(0, 1) + "."+ str.substr(str.length - 3, 3);
			}
		if (str.length == 5){
			objTextBox.value = str.substr(0, 2) + "."+ str.substr(str.length - 3, 3);
			}
		if (str.length == 6){
			objTextBox.value = str.substr(0, 3) + "."+ str.substr(str.length - 3, 3);
			}
		/*if (str.length == 7){
			objTextBox.value = str.substr(0, 3) + "."+ str.substr(str.length - 3, 3);
			}
		if (str.length == 8){
			objTextBox.value = str.substr(0, 3) + "."+ str.substr(str.length - 3, 3);
			}
		if(str='000.000'){
			str = "";
		}*/
	},
	numericaPorcentagemLimitada : function(objTextBox) {
		var str = objTextBox.value;
		var caract = /[^0-9]/;
		while (caract.test(str)){str = str.replace(caract, "");}
		str = str.replace(caract, "");
		if (str.length > 5){str = str.substr(0, str.length - (str.length - 5));}
		if (str.length < 2){objTextBox.value = str;}
		if (str.length == 2){objTextBox.value = str.substr(0, 1) + "."
				+ str.substr(str.length - 1, 1);}
		if (str.length == 3){objTextBox.value = str.substr(0, 1) + "."
				+ str.substr(str.length - 2, 2);}
		if (str.length == 4){objTextBox.value = str.substr(0, 2) + "."
				+ str.substr(str.length - 2, 2);}
		if (str.length == 5){objTextBox.value = str.substr(0, 3) + "."
				+ str.substr(str.length - 2, 2);}
		if (parseInt(str) > 10000){objTextBox.value = "100.00";}
	},
	number_format : function(number, decimals, dec_point, thousands_sep) {
		// Formats a number with grouped thousands
		//
		// version: 906.1806
		// discuss at: http://phpjs.org/functions/number_format
		// + original by: Jonas Raoni Soares Silva (http://www.jsfromhell.com)
		// + improved by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)
		// + bugfix by: Michael White (http://getsprink.com)
		// + bugfix by: Benjamin Lupton
		// + bugfix by: Allan Jensen (http://www.winternet.no)
		// + revised by: Jonas Raoni Soares Silva (http://www.jsfromhell.com)
		// + bugfix by: Howard Yeend
		// + revised by: Luke Smith (http://lucassmith.name)
		// + bugfix by: Diogo Resende
		// + bugfix by: Rival
		// + input by: Kheang Hok Chin (http://www.distantia.ca/)
		// + improved by: davook
		// + improved by: Brett Zamir (http://brett-zamir.me)
		// + input by: Jay Klehr
		// + improved by: Brett Zamir (http://brett-zamir.me)
		// + input by: Amir Habibi (http://www.residence-mixte.com/)
		// + bugfix by: Brett Zamir (http://brett-zamir.me)
		// * example 1: number_format(1234.56);
		// * returns 1: '1,235'
		// * example 2: number_format(1234.56, 2, ',', ' ');
		// * returns 2: '1 234,56'
		// * example 3: number_format(1234.5678, 2, '.', '');
		// * returns 3: '1234.57'
		// * example 4: number_format(67, 2, ',', '.');
		// * returns 4: '67,00'
		// * example 5: number_format(1000);
		// * returns 5: '1,000'
		// * example 6: number_format(67.311, 2);
		// * returns 6: '67.31'
		// * example 7: number_format(1000.55, 1);
		// * returns 7: '1,000.6'
		// * example 8: number_format(67000, 5, ',', '.');
		// * returns 8: '67.000,00000'
		// * example 9: number_format(0.9, 0);
		// * returns 9: '1'
		// * example 10: number_format('1.20', 2);
		// * returns 10: '1.20'
		// * example 11: number_format('1.20', 4);
		// * returns 11: '1.2000'
		// * example 12: number_format('1.2000', 3);
		// * returns 12: '1.200'
		var n = number, prec = decimals;

		var toFixedFix = function(n, prec) {
			var k = Math.pow(10, prec);
			return (Math.round(n * k) / k).toString();
		};

		n = !isFinite(+n) ? 0 : +n;
		prec = !isFinite(+prec) ? 0 : Math.abs(prec);
		var sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep;
		var dec = (typeof dec_point === 'undefined') ? '.' : dec_point;

		var s = (prec > 0) ? toFixedFix(n, prec) : toFixedFix(Math.round(n),
				prec); // fix
		// for
		// IE
		// parseFloat(0.55).toFixed(0)
		// = 0;

		var abs = toFixedFix(Math.abs(n), prec);
		var _, i;

		if (abs >= 1000) {
			_ = abs.split(/\D/);
			i = _[0].length % 3 || 3;

			_[0] = s.slice(0, i + (n < 0))
					+ _[0].slice(i).replace(/(\d{3})/g, sep + '$1');
			s = _.join(dec);
		} else {
			s = s.replace('.', dec);
		}

		var decPos = s.indexOf(dec);
		if (prec >= 1 && decPos !== -1 && (s.length - decPos - 1) < prec) {
			s += new Array(prec - (s.length - decPos - 1)).join(0) + '0';
		} else if (prec >= 1 && decPos === -1) {
			s += dec + new Array(prec).join(0) + '0';
		}
		return s;
	},
	semNumeros : function(obj) {
		var exp = /[0-9]/;
		var str = obj.value;
		while (exp.test(str)) {
			str = str.replace(exp, '');
		}
		obj.value = str;

	},
	limpaCampoNumerico : function(obj) {
		if (obj.value == "0") {
			obj.value = "";
		}
	},
	completaCampoNumerico : function(obj) {
		if (obj.value == "") {
			obj.value = "0";
		}
	}


}

function VerificaData(campo) {
	var data = campo.value;

	var tam = data.length;
	if (tam != 10) {
		campo.value = "";
		// alert("\"" + cData + "\" não é uma data válida.");
		return false;
	}
	var dia = data.substr(0, 2);
	var mes = data.substr(3, 2);
	var ano = data.substr(6, 4);
	if (ano < 1600) {
		campo.value = "";
		return false;
	}

	if (mes > 12 || mes < 1) {
		campo.value = "";
		return false;
	}

	switch (mes) {
	case '01':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '02':
		if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
			// Se for bissexto pode o dia ser no máximo 29
			if (dia > 29){campo.value = "";}
			return false;
			// se não for bisexto o dia pode ser no máximo 28
		} else if (dia > 28) {
			campo.value = "";
			return false;
		} else {
			return true;
		}
		break;
	case '03':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '04':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '05':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '06':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '07':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '08':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '09':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '10':
		if (dia <= 31) {
			return (true);
		}
		break;
	case '11':
		if (dia <= 30) {
			return (true);
		}
		break;
	case '12':
		if (dia <= 31) {
			return (true);
		}
		break;
	}
	campo.value = "";
	return false;
}

function showStatus(){
	PF('statusDialog').show();
}
function hideStatus(){
	PF('statusDialog').hide();
}

/**
 * @author Henrique
 * @function Enter como tabulação
 * */
function checkForEnter (event) {  
    console.log(this);  
    if (event.keyCode == 13) {  
        currentBoxNumber = textboxes.index(this);  
          
        if (textboxes[currentBoxNumber + 1] != null) {  
            nextBox = textboxes[currentBoxNumber + 1]  
            nextBox.focus();  
            event.preventDefault();  
            return false;  
        }      
    }  
}  

function formatarCampoMoeda(pInput, pComSeparadorMilhar) {
	
	var str = pInput.toString();
	
	if (str.indexOf('.') == -1) {
		str = str + '.00';
	} else {
		var indice = str.indexOf('.');
		var tam = str.substring(indice + 1);
		if (tam.length == 1) {
			str = str + '0';
		} else {
			if (tam.length > 2) {
				str = str.substring(0, indice + 3);
			}
		}
		
	}
	
	var valorSemMascara = str.replace('.', ',');
	var valorComMascara;

	if (pComSeparadorMilhar) {

		var ponto = '';
		var ultimoIndice = 0;

		valorComMascara = "";

		if (valorSemMascara.lastIndexOf(',') == -1) {
			ultimoIndice = valorSemMascara.length;
		} else {
			ultimoIndice = valorSemMascara.lastIndexOf(',');
		}

		var teste;
		for (var contador = ultimoIndice; contador > 0; contador = contador - 3) {
			teste = contador;
			if ((teste - 3) < 0) {
				if (valorSemMascara.indexOf('-') == 0) {
					valorComMascara = valorSemMascara.substring(0, contador) + valorComMascara;
				} else {
					valorComMascara = valorSemMascara.substring(0, contador) + ponto + valorComMascara;
				}
			} else {
				valorComMascara = valorSemMascara.substring((contador - 3), contador) + ponto + valorComMascara;
			}

			ponto = '.';
		}

		valorComMascara =
			valorComMascara + valorSemMascara.substring(valorSemMascara.lastIndexOf(','), valorSemMascara.length);
	} else {
		valorComMascara = valorSemMascara;
	}

	return valorComMascara;
}

function mascaraPeso(objTextBox){
	 
	
		var v = objTextBox.value;
		//integer = v.split(',')[0];
		//v = v.replace(/\D/, "");
		//v = v.replace(/^[0]+/, "");
		var existe=false;
		var cont=0;
		v = v.replace(",",".");
		for(var i=0;i<v.length;i++){
			if(v.charAt(i)=="," ||v.charAt(i)=="."){
				existe=true;
				cont=i;
				if(v.charAt(i)==","){
					v.charAt(i)==".";
				}
			}
		}
		var texto=v;
		
		if(existe==true){
			if(v.substr(cont)!=',' || v.substr(cont)!='.'){
				var resto = v.substr(cont+1);
				if(resto.length>=4){
				  texto = texto.substr(0,cont)+ texto.substr(cont,4);
				}
			}
			
			//if(v.length === 6) v = '0,' + v;
		}
		else {
			//if(v.length === 1) v = '0,000' + v;
			if(v.length === 3){
				texto = v.substr(0,3)+"."+v.substr(3);			//'0,0' + v;
			}
			if(v.length === 4){
				texto = v.substr(0,1)+"."+v.substr(1);			//'0,0' + v;
			}		
			if(v.length === 5){
				texto = v.substr(0,2)+"."+v.substr(2);			//'0,0' + v;
			}
			if(v.length === 6){
				texto = v.substr(0,3)+"."+v.substr(3);			//'0,0' + v;
			}
				}
		
			// texto=v;			//v = v.replace(/^(\d{1,})(\d{4})$/, "$1,$3");
		

		objTextBox.value = texto;
	
}

function disableCtrlKeyCombination(e)
{
	//list all CTRL + key combinations you want to disable
	/**'a', 'n', 'c', 'x', 'v', 'j'*/
	var forbiddenKeys = new Array('a', 'n', 'c', 'x', 'v', 'j');
	/*forbiddenKeys[0]='a';
	forbiddenKeys[1]='n';
	forbiddenKeys[2]='c';
	forbiddenKeys[3]='x';
	forbiddenKeys[4]='v';
	forbiddenKeys[5]='j';*/
	
	
	var key;
	var isCtrl;

	if(window.event)
	{
		key = window.event.keyCode;     //IE
		if(window.event.ctrlKey)
                        isCtrl = true;
                else
                        isCtrl = false;
	}
	else
	{
		key = e.which;     //firefox
		if(e.ctrlKey)
			isCtrl = true;
		else
			isCtrl = false;
	}

	//if ctrl is pressed check if other key is in forbidenKeys array
	if(isCtrl)
	{
		for(var i=0; i<forbiddenKeys.length; i++)
		{
			//case-insensitive comparation
			/*if(forbiddenKeys[i].toLowerCase() == String.fromCharCode(key).toLowerCase())
			{*/
				alert('Key combination CTRL + '
					+String.fromCharCode(key) + '  keyCode  '+key
					+' has been disabled.');
				return false;
			//}
		}
	}
	return true;
}
function mascaraTelefone(fone){
	JEffects.masks.telefone(fone);
}

function retirarZeros(valor){
	var retorno =valor.value;
	retorno=retorno.substring(retorno.length-1) ==0 ?retorno:retorno.substring(0,retorno.length);
	
	return retorno;
}
