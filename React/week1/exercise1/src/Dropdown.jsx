import React, { useContext } from "react";

import { LocalisationContext } from "./localisation";

export default function Dropdown() {
  const {
    localisationStore: [, dispatch],
    availableLanguages
  } = useContext(LocalisationContext);

  const handleSelected = e => {
    const {
      target: { value }
    } = e;
    dispatch({ type: "LANGUAGE_UPDATE", payload: value });
  };

  function getOptions(langs) {
    return langs.map(({ shortCode, label }) => {
      return <option key={shortCode} value={shortCode}>{label}</option>;
    });
  }

  return (
    <select onChange={handleSelected}>{getOptions(availableLanguages)}</select>
  );
}
