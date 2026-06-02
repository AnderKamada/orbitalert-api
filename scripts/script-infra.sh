#!/bin/bash

RESOURCE_GROUP=rg-orbitalert
LOCATION=brazilsouth
APP_NAME=orbitalert-api

az group create \
  --name $RESOURCE_GROUP \
  --location $LOCATION

az appservice plan create \
  --name orbitalert-plan \
  --resource-group $RESOURCE_GROUP \
  --sku B1 \
  --is-linux

az webapp create \
  --resource-group $RESOURCE_GROUP \
  --plan orbitalert-plan \
  --name $APP_NAME \
  --runtime "JAVA|21-java21"