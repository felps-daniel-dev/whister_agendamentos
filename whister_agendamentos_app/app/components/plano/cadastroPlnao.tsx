"use client";

import { useState } from "react";

interface CadastroPlanoProps {
  isOpen: boolean;
  onClose: () => void;
  onSave?: (plano: { nome: string; qtd_consultas_gratis_trimestral: number; desconto: number }) => void;
}

export const CadastroPlano: React.FC<CadastroPlanoProps> = ({
  isOpen,
  onClose,
  onSave,
}) => {
  // Estados para os 3 campos
  const [nome, setNome] = useState("");
  const [qtdConsultas, setQtdConsultas] = useState<number | "">("");
  const [desconto, setDesconto] = useState<number | "">("");

  // Se o modal não estiver aberto, não renderiza nada
  if (!isOpen) return null;

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (onSave) {
      onSave({
        nome,
        qtd_consultas_gratis_trimestral: Number(qtdConsultas),
        desconto: Number(desconto),
      });
    }
    onClose();
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-slate-900/40 backdrop-blur-xs p-4">
      
     
      <div className="w-full max-w-md bg-white rounded-2xl shadow-xl border border-slate-100 overflow-hidden animate-fadeIn">
        
        <div className="flex items-center justify-between px-6 py-4 border-b border-slate-100">
          <h2 className="text-lg font-bold text-slate-800">Novo Plano</h2>
          
          <button
            onClick={onClose}
            type="button"
            className="text-slate-400 hover:text-slate-600 p-1 rounded-lg hover:bg-slate-100 transition-colors cursor-pointer"
          >
            <svg className="w-5 h-5 stroke-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" d="M6 18L18 6M6 6l12 12" />
            </svg>
          </button>
        </div>

        <form onSubmit={handleSubmit} className="p-6 space-y-4">
          
          <div className="space-y-1">
            <label className="text-xs font-bold text-slate-500 uppercase tracking-wider">
              Nome do Plano
            </label>
            <input
              type="text"
              required
              placeholder="Ex: Unimed Bronze"
              value={nome}
              onChange={(e) => setNome(e.target.value)}
              className="w-full px-3.5 py-2.5 bg-slate-50 border border-slate-200/80 rounded-xl text-sm text-slate-800 placeholder-slate-400 focus:outline-none focus:border-[#00828a] focus:bg-white transition-all"
            />
          </div>

          <div className="grid grid-cols-2 gap-3">
            
            <div className="space-y-1">
              <label className="text-xs font-bold text-slate-500 uppercase tracking-wider">
                Qtd. Grátis (Trimestral)
              </label>
              <input
                type="number"
                required
                min="0"
                placeholder="0"
                value={qtdConsultas}
                onChange={(e) => setQtdConsultas(e.target.value === "" ? "" : Number(e.target.value))}
                className="w-full px-3.5 py-2.5 bg-slate-50 border border-slate-200/80 rounded-xl text-sm text-slate-800 placeholder-slate-400 focus:outline-none focus:border-[#00828a] focus:bg-white transition-all"
              />
            </div>

            <div className="space-y-1">
              <label className="text-xs font-bold text-slate-500 uppercase tracking-wider">
                Desconto (%)
              </label>
              <input
                type="number"
                required
                min="0"
                max="100"
                step="0.1"
                placeholder="0.0"
                value={desconto}
                onChange={(e) => setDesconto(e.target.value === "" ? "" : Number(e.target.value))}
                className="w-full px-3.5 py-2.5 bg-slate-50 border border-slate-200/80 rounded-xl text-sm text-slate-800 placeholder-slate-400 focus:outline-none focus:border-[#00828a] focus:bg-white transition-all"
              />
            </div>

          </div>

          {/* Botões do Rodapé */}
          <div className="flex items-center justify-end gap-3 pt-4 border-t border-slate-100 mt-6">
            <button
              type="button"
              onClick={onClose}
              className="px-4 py-2 text-sm font-semibold text-slate-600 hover:text-slate-800 hover:bg-slate-100 rounded-xl transition-colors cursor-pointer"
            >
              Cancelar
            </button>
            <button
              type="submit"
              className="px-5 py-2 text-sm font-semibold text-white bg-[#00828a] hover:bg-[#006e75] rounded-xl transition-all shadow-sm shadow-[#00828a]/20 cursor-pointer"
            >
              Cadastrar
            </button>
          </div>

        </form>

      </div>
    </div>
  );
};