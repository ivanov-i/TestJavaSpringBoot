#!/bin/bash
set -e

old=`curl -s -X POST -H "Content-Type: application/json" -d\
	'{"serialNumber":"12345","manufacturer":"Dell","price":1000.0,"quantity":10,"type":"Desktop","formFactor":"Nettop"}'\
	http://localhost:8080/desktops`

id=`echo $old | jq '.id'`

echo created with id = $id

new=`curl -s -X PUT -H "Content-Type: application/json" -d\
	'{"manufacturer":"Dell-updated"}'\
	http://localhost:8080/desktops/$id`

echo
echo updated successfully
echo
echo original: $old
echo updated : $new


