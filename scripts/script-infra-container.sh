#!/bin/bash

RESOURCE_GROUP=rg-orbitalert-dev

az container create \
  --resource-group $RESOURCE_GROUP \
  --name orbitalert-api-container \
  --image orbitalertacr.azurecr.io/orbitalert-api:latest \
  --cpu 1 \
  --memory 1 \
  --registry-login-server orbitalertacr.azurecr.io \
  --registry-username orbitalertacr \
  --registry-password ${ACR_PASSWORD} \
  --dns-name-label orbitalert-api-$RANDOM \
  --ports 8080