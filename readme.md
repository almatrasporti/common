# Common utilities per Almatrasporti

Questo package fornisce alcune utilità comuni per la suite Almatrasporti.

La libreria espone le seguenti classi:

- `org.almatrasporti.common.utils.Config`: classe _singleton_ class per la creazione di un repository di configurazione
da file, il cui percorso viene fornito come `property` applicativa al momento del lancio dell'applicazione, col nome 
`properties.file`.  


- `org.almatrasporti.common.models.CANBusMessage`: Classe che modella un messaggio ricevuto da una centralina a bordo di
un veicolo, fornendo una validazione dati di base:
  - tutti i campi devono essere non nulli
  - `VIN`, stringa non vuota
  - `timestamp`, intero non negativo
  - `driver`, stringa non vuota
  - `odometer`, intero non negativo
  - `lifeConsumption`, intero non negativo
  - `lon`, valore numerico
  - `lat`, valore numerico
  - `altitude`, valore numerico
  - `heading`, valore numerico non negativo
  - `speed`, valore numerico non negativo
  - `satellites`, valore numerico non negativo
  
  
- `org.almatrasporti.common.services.serializers.BatchCANBusMessageSerializer`: classe per la serializzazione di un
 `CANBusMessage' come document json nel formato richiesto per il batch processing.
 
 
- `org.almatrasporti.common.services.serializers.RealtimeCANBusMessageSerializer`: classe per la serializzazione di un
 `CANBusMessage` come document json nel formato richiesto per il realtime processing.
 
 
- `org.almatrasporti.common.services.CANBusMessageFactory`: classe _Factory_ per la creazione di `CANBusMessage` da un 
formato specifico. Attualmente l'unico formato implementato è il _csv_.


- `org.almatrasporti.common.services.CANBusMessageFormatter`: classe per la formattazione di un `CANBusMessage' in uno 
dei formati supportati. Attualmente i formati supportato sono i seguenti:
  - `csv`
  - `raw json`
  - `batch json`
  - `real-time json`

