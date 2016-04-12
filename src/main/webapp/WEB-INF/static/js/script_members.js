angular.module('myApp', [])
	.controller('customersCtrl', ['$scope','$http', function($scope,$http) {
		$http.get("/member/getAll").
			then(function(response) {
				$scope.myData = response.data;
			}
		);
		
		$scope.filterPeople = function() {								
			var dataObj = {
					"skills": $('#dropdownMenu1').text(),
					"responsibility": $('#dropdownMenu2').text(),
					"timeWithUs": $('#dropdownMenu3').text()
			};	
			var res = $http.post('/member/getAllByParams', dataObj);

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
