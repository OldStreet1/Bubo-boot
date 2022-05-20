import appConfig from "../../config";
export default {
	rop: {
		state: {
			serverUrl: appConfig.app.serverUrl,
			appKey: appConfig.app._appkey,
			appSecret: appConfig.app._appSecret,
			locale: 'zh',
			sessionId: "",
			sysClock: 0,
			localClock: 0,
			aes: false,
			wxSecret: appConfig.app.wxSecret,
			appId:appConfig.app.appId,
		},
		mutations: {
			es_serverUrl(state, value) {
				state.serverUrl = value;
				uni.setStorageSync('serverUrl', value);
			},
			es_locale(state, value) {
				state.locale = value;
			},
			es_sessionId(state, value, temp) {
				if (temp) {
					state.sessionId = "1";
				} else {
					state.sessionId = value;
				}
			},
			es_sysClock(state, value) {
				state.sysClock = value;
			},
			es_localClock(state, value) {
				state.localClock = value;
			},
			es_aes(state, value) {
				state.aes = value;
			}
		},
	},
	user: {
		state: {
			userId: "",
			personId: "",
			username: "",
			cnName: "",
			mobile: "",
			orgName: "",
			dwOrgName: ""
		},
		mutations: {
			es_userId(state, value) {
				state.userId = value;
			},
			es_personId(state, value) {
				state.personId = value;
			},
			es_username(state, value) {
				state.username = value;
			},
			es_cnName(state, value) {
				state.cnName = value;
			},
			es_mobile(state, value) {
				state.mobile = value;
			},
			es_orgName(state, value) {
				state.orgName = value;
			},
			es_dwOrgName(state, value) {
				state.dwOrgName = value;
			},
		}
	},
	app: {
		state: {
			osType: "1",
			clientType: appConfig.app.clientType,
			loginPage: appConfig.app.loginPage,
			updatePage: appConfig.app.updatePage,
			mainPage: appConfig.app.mainPage,
			mainUICfg: null,
			versionName: appConfig.app.versionName,
			versionNum: appConfig.app.versionNum,
			mbAppCode: appConfig.app.mbAppCode,
			fileServerUrl: appConfig.app.serverUrl,
			menuReportClock: 0,
			appReportClock: 0,
			gpsRecordTimer: appConfig.app.gpsRecordTimer,
			gpsUploadTimer: appConfig.app.gpsUploadTimer,
			gpsRecordNum: appConfig.app.gpsRecordNum,
			durationRecordTimer: appConfig.app.durationRecordTimer,
			durationUploadTimer: appConfig.app.durationUploadTimer,
			appUpdateCheckUrl: appConfig.app.appUpdateCheckUrl,
			appUpdateDownloadUrl: appConfig.app.appUpdateDownloadUrl,
			urlKey: appConfig.app.urlKey,
			amapWebKey: appConfig.app.amapWebKey,
			QQMapKey: appConfig.app.QQMapKey,
			appType: appConfig.app.appType,
		},
		mutations: {
			es_menuReportClock(state, value) {
				state.menuReportClock = value;
			},
			es_appReportClock(state, value) {
				state.appReportClock = value;
			},
			es_mainUICfg(state, value) {
				state.mainUICfg = value;
			},
			es_osType(state, value) {
				state.osType = value;
			},
			es_fileServerUrl(state, value) {
				state.fileServerUrl = value;
				uni.setStorageSync('fileServerUrl', value);
			}
		}
	}
};
