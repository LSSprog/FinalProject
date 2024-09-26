angular.module('app').controller('homeController', function($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8701/zuul/';
    let product = {id: 1, title: 'super'};

    $scope.test = function () {
        $http.put(contextPath + 'service/admin/create', product )
            .then(function successCalback(response){
                $scope.basketProduct = response.data
                console.log(response.data)
            });
    };

    $scope.test1 = function () {
        $http.post(contextPath + 'service/admin/add', product )
            .then(function successCalback(response){
                $scope.basketProduct = response.data
                console.log(response.data)
            });
    };

    $scope.test2 = function () {
        let id = 29;
        $http.delete(contextPath + 'service/admin/' + id )
            .then(function successCalback(response){
                $scope.basketProduct = response.data
                console.log(response.data)
            });
    };


    $scope.test3 = function () {
        let id = 1;
        $http.get(contextPath + 'service/order')
            .then(function successCalback(response){
                $scope.basketProduct = response.data
                console.log(response.data)
            });
    };

    // $scope.foon = function () {
    //     var product = {id: 1, title: super}
    //     $http.put(contextPath + 'service/products/create', product)
    //         .then(function (response) {
    //             $scope.productsH = response.data;
    //             console.log($http.defaults.headers.common.Authorization);
    //         });
    // }
});