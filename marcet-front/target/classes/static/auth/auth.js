angular.module('app').controller('authController', function($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8701/zuul/';


    $scope.auth = function () {
        $http.post(contextPath + 'service/auth', $scope.user)
            .then(function successCalback(response) {
                console.log(response)
                if(response.data.jwtResponse.token){
                    $scope.authBool = true;

                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.jwtResponse.token
                    console.log(response.data.addressDTOList[0].addressId)
                    $localStorage.currentUser = {username: $scope.user.username, token: response.data.token, adressId: response.data.addressDTOList[0].addressId};
                    $scope.authBool = true;
                }
            }, function errorCallback(response) {
                $scope.authBool = false
                window.alert("Error");
            });
    }

});