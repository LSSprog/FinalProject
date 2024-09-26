angular.module('app').controller('basketController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8701/zuul/';
    let userName;
    let addressId;
    userName = $localStorage.currentUser.username;
    addressId = $localStorage.currentUser.adressId;

    $scope.getBasket = function () {
        $http.get(contextPath + 'service/basket/get-basket')
            .then(function (response) {
                console.log(response)
                $scope.basketProduct = response.data;
                $scope.sumCost();
            });
    };

    $scope.delProductOfBasket = function (productDTO) {
        console.log(productDTO + "    product")
        $http.post(contextPath + 'service/basket/del', productDTO)
            .then(function (response){
                $scope.basketProduct = response.data;
                $scope.sumCost();
            })
    }

    $scope.sumCost = function(){
        var sum = 0;
        for(var i=0; i < $scope.basketProduct.length; i++){
            sum += $scope.basketProduct[i].cost;
        }
        $scope.totalCost = sum;
        console.log($scope.totalCost);
    }

    $scope.createOrder = function(){
        let orderDTO = {    userName: $localStorage.currentUser.username,
                        addressId: $localStorage.currentUser.adressId
        }

        console.log(orderDTO)
        $http.post(contextPath + 'service/order/create', orderDTO)
            .then(function (response){
                console.log(response.data)
                $scope.orderNumber = response.data.orderId
            })
    }

    $scope.showOrder = function(orderNumber){
        console.log(orderNumber)
        $scope.getAdressNoUserName();
        $http.post(contextPath + 'service/order/show', orderNumber)
            .then(function (response){
                console.log(response)
            })
    }

    $scope.getAdressNoUserName = function(){
        userName = $localStorage.currentUser.username;
            $http.post(contextPath + 'service/address/username', userName)
                .then(function(response){
                    console.log(response)
                })
    }

    $scope.decrimentCount = function (p){
        console.log(p);
        $http.post(contextPath + 'service/basket/decriment', p)
            .then(function(response){
                $scope.basketProduct = response.data
                console.log(response)
            })
    }

    $scope.incrementCount = function (product) {
        console.log(product)
        $http.post(contextPath + 'service/basket/add', product )
            .then(function successCalback(response){
                $scope.basketProduct = response.data
                console.log(response.data)
            });
    };


    $scope.getBasket();

});

