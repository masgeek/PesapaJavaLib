## PesapalJavaLib

Java library for easily integrate web and mobile payments with [pesapal.com](www.pesapal.com).

## Code Example

Can see an example [here](https://github.com/bubinimara/PesapalAndroidTest)

First of all [Download](https://github.com/bubinimara/PesapaJavaLib/releases) and include the library.

**Initialize**

```
Pesapal.initialize("put your key","put your secret");
Pesapal.setDEMO(false); // demo or live version
```

**Build the request**

```
PostRequest.Builder builder = new PostRequest.Builder();
//Can take it from editText or where there you want
builder
.isMobile(true)
.amount("1000")
.description("from new libs")
.mail("lib@mail.com")
.name("lib", "newlib");
```

**Get the signed URL for send requets**
```
PostRequest req = builder.build();
String url = req.getURL(); // send it 

```

**Get a signed URL for get the status**

```
IpnRequestStatus request = new IpnRequestStatus(id,reference);
String url = request.getURL();
```

## Installation

* Download and put the jar in lib directory

## Dependency

* [Signpost](http://code.google.com/p/oauth-signpost/) - tested with (signpost-core-1.2.1.2.jar)
* [Commons-codec](http://commons.apache.org/proper/commons-codec/) - tested with (commons-codec-1.9.jar)



## License

 * [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

