// Programa : Leitura e gravação dos dados em um arquivo .txt
// Autor : Mário Paulino


// Carregando as biblioteca
#include <SD.h>
#include <SoftwareSerial.h>
#include <SPI.h>
#include <MFRC522.h>

//Inicialização do cartão SD
Sd2Card SDcard;
SdVolume volume;

//Definição de pino para recebimento dos dados
#define SS_PIN 3
#define RST_PIN 2

//Passagem de parametros para a função MFRC
MFRC522 mfrc522(SS_PIN, RST_PIN);

// Pino de comunicação entre o arduino e o leitor de cartão SD
const int chipSelect = 4;
void setup()
{


  Serial.begin(9600);
  SPI.begin();      // Iniciando  SPI bus
  mfrc522.PCD_Init();   // Iniciando MFRC522
  //Inicia a comunicacao com o modulo SD
  if (!SD.begin(chipSelect))
  {
    Serial.println("Falha ao acessar o cartao !");
    Serial.println("Verifique o cartao/conexoes e reinicie o Arduino...");
    return;
  }
  Serial.println("Cartao iniciado corretamente !");
  Serial.println();
  Serial.println("Universidade Estadual da Paraiba - UEPB ");
  Serial.println("Laboratorio de Programacao "); // Mostra informacoes no display
  Serial.println("Projeto sobre Monitoramento Escolar");
  Serial.println();
  Serial.print("Aproxime a identificacao");
  Serial.println();

}

void loop() {
  if ( ! mfrc522.PICC_IsNewCardPresent()) //Reconhecendo cartões não cadastrados
  {
    return;
  }
  // Select one of the cards
  if ( ! mfrc522.PICC_ReadCardSerial()) // Lendo e identificando os cartões
  {
    return;
  }

  // Abre o arquivo arquivo.txt do cartao SD
  File dataFile = SD.open("arduino.txt", FILE_WRITE);
  // Grava os dados no arquivo
  
  if (dataFile)
  {
    //Serial.print("UID da tag :");
    String conteudo = "";
    byte letra;
    for (byte i = 0; i < mfrc522.uid.size; i++)
    {
      Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");//Mostra o codigo do cartão
      Serial.print(mfrc522.uid.uidByte[i], HEX);
      conteudo.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
      conteudo.concat(String(mfrc522.uid.uidByte[i], HEX));
      
    }
      dataFile.println(conteudo);
      Serial.println();
      Serial.println("Presenca Confirmada");
      Serial.println();
      delay(3000);
      Serial.print("Aproxime a identificacao");
      Serial.println();
      //Serial.println("Aproxime a identificacao");
      

    //Serial.println();
   // Serial.print("Mensagem : ");
    //conteudo.toUpperCase();
    //switch (conteudo != ""){
   // case 1 (conteudo.substring == "F3 3A CE F7") //UID 1 - Cartão
    //{
    //  dataFile.println("Seja bem vindo, AJ!!");
    // Serial.println("Seja bem vindo, AJ!!");
    //break;
    //}
    //case 2 (conteudo.substring ==  "17 26 07 42") //UID 2 - Cartao
    //{
    //Serial.println("Seja bem vindo, Mario !!");
     //dataFile.println("Seja bem vindo, Mario !!");
     //break;
    //}
   
    dataFile.close();
  }
  else
  {
    // Mensagem de erro caso ocorra algum problema
    // na abertura do arquivo
    Serial.println("Erro ao abrir arquivo.txt !");
  }
}

