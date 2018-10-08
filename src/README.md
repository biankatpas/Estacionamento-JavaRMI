# Estudo dirigido: sistemas distribuídos
## Problema
Desenvolva um aplicativo cliente / servidor baseado em Java RMI para fazer o controle de entrada e saída de bicicletas de um estacionamento de aluguel de bicicletas.
* O aplicativo servidor é responsável por manter o histórico de entrada e saída das bicicletas (em memória). 
* As bicicletas já estão registradas no servidor e cada uma possui um Id único. 
* O aplicativo cliente é responsável por: 
  * registrar o aluguel de uma bike (indicar o id_bike, data, hora), 
  * registrar a devolução de uma bike, 
  * consultar o valor a ser pago pelo aluguel (cada hora custa 5,00, de 4 horas a 24h horas custa 20,00), 
  * consultar quais bicicletas estão alugadas e quais estão no estacionamento.
