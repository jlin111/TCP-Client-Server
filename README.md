# Progetto Socket TCP/UDP


## Introduzione
Lo scopo del progetto era quello di creare due applicativi in Java che sfruttassero le connessioni TCP e UDP per comunicare.
Ciascuno di questi è formato da due file in Java: un server ed un client. Essi sono posti su due macchine diverse (quindi con indirizzi IP diversi).
La nostra applicazione può definirsi infatti un’applicazione distribuita.
Con diversi protocolli di comunicazione, il nostro scopo era quello di comunicare con macchine differenti all’interno della stessa rete di calcolatori.
Il due protocolli (quindi parliamo dello strato 4 della pila ISO/OSI) che abbiamo usato sono i seguenti:
•	TCP/IP - Transmission Control Protocol/Internet Protocol, che è connection-oriented. Il TCP/IP è un protocollo di comunicazione orientato alla connessione. Quindi garantisce che i pacchetti inviati arrivino a destinazione (in caso di errori il client richiede la ritrasmissione).
•	UDP - (User Datagram Protocol), che si definisce connectionless. L’UDP è un protocollo adatto a quei servizi di streaming in cui è preferibile ricevere i pacchetti in tempo, piuttosto che in modo integro.

## Teoria alla base
Java utilizza per la comunicazione in rete il paradigma di programmazione basato sul concetto di socket. Un socket, in informatica, indica un'astrazione software progettata per utilizzare delle API standard e condivise per la trasmissione e la ricezione di dati attraverso una rete oppure come meccanismo di IPC.
È il punto in cui il codice applicativo di un processo accede al canale di comunicazione per mezzo di una porta, ottenendo una comunicazione tra processi che lavorano su due macchine fisicamente separate.
Dal punto di vista di un programmatore un socket è un particolare oggetto sul quale leggere e scrivere i dati da trasmettere o ricevere.
Il socket può essere definito come un punto terminale o di aggancio di una linea di comunicazione da cui un programma può inviare i dati in rete e può ricevere i dati dalla rete.
Un socket è un descrittore di risorsa che consente ad una applicazione di effettuare operazioni di lettura/scrittura verso un particolare dispositivo di I/O.
I socket sono stati introdotti nel 1983 in BSD e poi sono stati ripresi da praticamente tutti gli altri sistemi operativi. Per questo motivo solitamente le funzioni di programmazione dei socket vengono chiamate Berkeley socket API.
Essi permettono di instaurare le varie comunicazioni all’interno della rete. Essi sono composti principalmente da due parti:
•	Indirizzo IP: codice univoco della macchina interessata, con una grandezza di 32 bit.
•	Numero di porta: numero, con una grandezza di 16 bit, usato dal singolo processo per richiedere il protocollo all’interno della macchina stessa.
Questa combinazione permette di distinguere in maniera univoca le singole richieste all’interno della rete.
Il socket (la traduzione letterale e presa di corrente) e un'astrazione software che è in qualche modo l'equivalente della presa elettrica per gli apparecchi elettrici.
In pratica un socket e una coppia di valori, il primo identifica un computer e il secondo un processo sul computer: scendendo più in dettaglio un socket e formato da un indirizzo IP che identifica un computer sulla rete e da un numero di porta TCP (2 byte) che identifica un processo o un'applicazione in esecuzione.
Il socket rappresenta solo uno dei due capi di una comunicazione; due computer per comunicare usano ciascuno un socket e tra i due socket si crea una connessione (full-duplex) per il trasferimento dei dati in due direzioni.
La realizzazione di applicazioni client/server in Java come vedremo tra poco si basa sulle classi contenute nel package java.net e in particolare sulle classi InetAddress, ServerSocket e Socket.

## Funzionamento
Il client effettua la richiesta di esecuzione di un servizio. La sua controparte, il lato server, effettua l’esecuzione del servizio richiesto.
Chiaramente, è necessario che il lato client e quello server si "intendano" esattamente circa il significato della richiesta e della relativa replica. Si introduce allora il concetto di Protocollo.
I protocolli implementano quelle funzionalità che consentono lo scambio di messaggio sul mezzo fisico disposto fra due macchine, (ad esempio la suddivisione in quadri, il rilevamento di errori, il controllo di flusso ecc.).
Per attivare una connessione fra due processi si utilizza dunque lo schema Host:Port, in cui il server è eseguito su un host e aspetta richieste su una determinata porta. Il client viene eseguito su un host e richiede l’uso di una porta per effettuare richieste ad un server.
Ricordiamo brevemente che un programma e detto client se richiede un servizio a un programma detto server che fornisce il servizio richiesto e poi si rimette in ascolto in attesa di ulteriori richieste da parte di altri client. É un modello asimmetrico (in contrapposizione col modello UDP che invece è simmetrico) chiamato anche request-replay perche si basa sul susseguirsi di richieste e risposte.
Può accadere frequentemente che su un server vi siano in esecuzione servizi diversi per cui, per distinguerli, si usa un numero identificativo del servizio: la rispettiva porta.
Inoltre un server singlethread (o server unicast o singlecast) e un server che comunica con un solo client alla volta (se esistono altri client, ogni cliente deve attendere il proprio turno), mentre se il server è multithread (o server multicast) al server possono connettersi contemporaneamente più client (per ogni client, il server attiva un thread distinto) e poi si rimette in ascolto di nuove connessioni.
Un server multithread gestisce la comunicazione con 2 client mediante due oggetti di tipo Socket. L'oggetto di tipo ServerSocket è detto socket di benvenuto e provvede a creare i socket di comunicazione coi client per ogni richiesta.
Cominciamo col vedere le istruzioni fondamentali per la creazione di un server unicast, che accetta richieste da parte di un client, fornisce la risposta (trasforma una stringa inviata dal client in maiuscolo) e quindi si rimettere in ascolto di una nuova richiesta.
Il server, se riceve più richieste, le mette in una coda di attesa, per cui fornisce il servizio ad un client alla volta.
>>>> classe TCPServer

Come si può osservare, nella classe sono presenti due parametri: l'indirizzo IP del server e la porta su cui esso risponde.
Ecco invece il codice del client Java.

>>>> classe TCPClient

## Test del programma
Per provare il programma, dobbiamo prima lanciare il server e successivamente il client, altrimenti la comunicazione non potrebbe avvenire.
Ecco il risultato dell'esecuzione. Partiamo dal server.
>>>> Output TCPServer
Ecco invece l’output che troviamo nel client:
>>>> Output TCPClient
