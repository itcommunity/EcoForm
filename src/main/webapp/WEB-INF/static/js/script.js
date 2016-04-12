angular.module('myApp', [])
	.controller('customersCtrl', ['$scope','$http', function($scope,$http) {
		$http.get("/group/getAll").
			then(function(response) {
				$scope.myData = response.data;
			}
		);
		
		$scope.filterPeople = function() {								
			var dataObj = {
					"skills": $('#dropdownMenu1').text(),
					"joinUmka": $('#dropdownMenu2').text(),
					"timeWithUs": $('#dropdownMenu3').text(),
					"members": $('#dropdownMenu4').text()

			};	
			var res = $http.post('/group/getAllByParams', dataObj);

			res.success(function(data, status, headers, config) {
				$scope.myData = data;
			});
			res.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});	
		
		};	
		
		$scope.displayField = function() {
			alert('sssss');
		}
}])
