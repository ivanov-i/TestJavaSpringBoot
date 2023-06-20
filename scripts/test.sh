#!/bin/bash
set -e

echo -----------desktops----------------

old=`curl -s -X POST -H "Content-Type: application/json" -d\
	'{"serialNumber":"12345","manufacturer":"Dell","price":1000.0,"quantity":10,"formFactor":"Nettop"}'\
	http://localhost:8080/desktops`

echo created $old

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

curl -s -X DELETE http://localhost:8080/products/$id

echo
echo -----------laptops----------------

old=`curl -s -X POST -H "Content-Type: application/json" -d\
	'{"serialNumber":"12345","manufacturer":"Dell","price":1000.0,"quantity":10,"size":18}'\
	http://localhost:8080/laptops`

echo created $old

id=`echo $old | jq '.id'`

echo created with id = $id

new=`curl -s -X PUT -H "Content-Type: application/json" -d\
	'{"manufacturer":"Dell-updated", "size":42}'\
	http://localhost:8080/laptops/$id`

echo
echo updated successfully
echo
echo original: $old
echo updated : $new

curl -s -X DELETE  http://localhost:8080/products/$id

echo
echo -----------monitors----------------

old=`curl -s -X POST -H "Content-Type: application/json" -d\
	'{"serialNumber":"12345","manufacturer":"Dell","price":1000.0,"quantity":10,"diagonal":18}'\
	http://localhost:8080/monitors`

echo created $old

id=`echo $old | jq '.id'`

echo created with id = $id

new=`curl -s -X PUT -H "Content-Type: application/json" -d\
	'{"manufacturer":"Dell-updated", "diagonal":42}'\
	http://localhost:8080/monitors/$id`

echo
echo updated successfully
echo
echo original: $old
echo updated : $new

curl -s -X DELETE  http://localhost:8080/products/$id

echo
echo -----------hdds----------------

old=`curl -s -X POST -H "Content-Type: application/json" -d\
	'{"serialNumber":"12345","manufacturer":"Dell","price":1000.0,"quantity":10,"capacity":18}'\
	http://localhost:8080/hdds`

echo created $old

id=`echo $old | jq '.id'`

echo created with id = $id

new=`curl -s -X PUT -H "Content-Type: application/json" -d\
	'{"manufacturer":"Dell-updated", "capasity":42}'\
	http://localhost:8080/hdds/$id`

echo
echo updated successfully
echo
echo original: $old
echo updated : $new

curl -s -X DELETE  http://localhost:8080/products/$id


