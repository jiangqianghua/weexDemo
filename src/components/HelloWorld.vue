<template>
	<div>
		<text @click="onClick">Android Toast</text>
		<text @click="onCallBack" class="calbackText">CallBack</text>
		<text @click="onNavigator" class="calbackText">navigator</text>
	</div>
</template>

<script>
	let navigator = weex.requireModule('navigator');
	module.exports = {
		methods: {
			onClick: function() {
				weex.requireModule('myModule').printLog("我是一个测试!");
			},
			onCallBack: function() {
				let func = weex.requireModule('myModule');
				func.nativeCallBack(function(event) {
					//回调后处理
					func.printLog('回调: ' + event);
				});
			},
			onNavigator: function() {
				navigator.push({
					url: 'http://www.52res.cn/login.js' //this.getJumpBaseUrl('login')
				})
			},
			getJumpBaseUrl: function(toUrl) {
				var bundleUrl = weex.config.bundleUrl;
				bundleUrl = new String(bundleUrl);
				var nativeBase;
				var native;
				if (WXEnvironment.platform === 'Android') {
					nativeBase = 'file://assets/dist/';
					native = nativeBase + toUrl + ".js";
				} else if (WXEnvironment.platform === 'iOS') {
					nativeBase = bundleUrl.substring(0, bundleUrl.lastIndexOf('/') + 1);
					native = nativeBase + toUrl + ".js";
				} else {
					var host = 'localhost:8081';
					var matches = /\/\/([^\/]+?)\//.exec(bundleUrl);
					if (matches && matches.length >= 2) {
						host = matches[1];
					}

					//此处需注意一下,tabbar 用的直接是jsbundle 的路径,但是navigator是直接跳转到新页面上的.  
					if (typeof window === 'object') {
						nativeBase = 'http://' + host + '/';
					} else {
						nativeBase = 'http://' + host + '/';
					}

					native = nativeBase + toUrl + ".html";
				}
				return native;
			}
		}
	}
</script>

<style scoped>
	.calbackText {
		margin-top: 100rem;
	}
</style>
