import React from 'react';
import { ReactKeycloakProvider } from '@react-keycloak/web';
import Keycloak, {KeycloakConfig, KeycloakInitOptions} from 'keycloak-js';
import ReportPage from './components/ReportPage';

const keycloakConfig: KeycloakConfig = {
  url: process.env.REACT_APP_KEYCLOAK_URL,
  realm: process.env.REACT_APP_KEYCLOAK_REALM||"",
  clientId: process.env.REACT_APP_KEYCLOAK_CLIENT_ID||""
};

const keycloakInitOptions: KeycloakInitOptions = {
  onLoad: 'login-required',
  checkLoginIframe: true,
  pkceMethod: "S256"
};

const keycloak = new Keycloak(keycloakConfig);

const App: React.FC = () => {
  return (
    <ReactKeycloakProvider
      authClient={keycloak}
      initOptions={keycloakInitOptions}>
      <div className="App">
        <ReportPage />
      </div>
    </ReactKeycloakProvider>
  );
};

export default App;