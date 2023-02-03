import React, { useReducer } from "react";

import dictionary from "./dictionary";

import {
  availableLanguages,
  initialState,
  reducer
} from "./localisationReducer";

export const LocalisationContext = React.createContext();

export function LocalisationProvider({ children }) {
  const localisationStore = useReducer(reducer, initialState);

  return (
    <LocalisationContext.Provider
      value={{ localisationStore, dictionary, availableLanguages }}
    >
      {children}
    </LocalisationContext.Provider>
  );
}
