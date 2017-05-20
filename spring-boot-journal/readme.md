# Spring Boot Application for Database Authentication and OAuth2 Support

This application has been developed to demonstrate how we can enable a spring boot application to be an OAuth provider. There are further enhancements we need to make it a full OAuth Provider.

When we run the application we need to note down the following bits of information. Look into the server start up log and copy what is shown below:

```
security.oauth2.client.clientId = 50d35a74-aa1f-445e-90f5-2ed3f1dff588
security.oauth2.client.secret = e7ab4c4d-701a-493e-a762-469e3b1ba8cc

```
These values may not be the same and change on every server restart. This project exposes two apis

* /api/journal - which lists all the journal entries in the database.
* /api/journal/add - which is a POST request that allows for data to be inserted to the backend store.

Both are protected by OAuth2.

First way to interact with the OAuth2 secured api's is to do use command line utility like curl

There are two steps to an  OAuth2 authorization and they are:
* obtain the oauth2 bearer token by passing the clientid and secret
* once the oauth2 token is available then we can call the api just by the oauth2 token.

The Authentication in this case is still done via database authentication provider


#### Obtaining the oauth2 token  

```
   curl -i http://localhost:7070/oauth/token -d "grant_type=password&scope=read&username=springb
oot&password=isawesome" -u 50d35a74-aa1f-445e-90f5-2ed3f1dff588:e7ab4c4d-701a-493e-a762-469e3b1ba8cc
```

This command should return oauth token in response:

```
{
  "access_token" : "226145ac-bfb9-46d4-8086-67a69a80c170",
  "token_type" : "bearer",
  "refresh_token" : "b7450aeb-b5e0-437c-9aa7-295042a9910c",
  "expires_in" : 42097,
  "scope" : "read"
}
```

Using the access token above we can access the /api/journal query api.

```
curl -i -H "Authorization: bearer 226145ac-bfb9-46d4-8086-67a69a80c170" http://localost:7070/api/journal
```

This will return a response which will be json form or the journal list.

Next development has to be of a web application that will consume this service from the outside - Oauth2 consuomer client application.
