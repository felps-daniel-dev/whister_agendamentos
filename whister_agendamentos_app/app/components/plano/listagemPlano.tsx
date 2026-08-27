"use client";

import { useServicePlano } from "@/app/services/useServicePlano";
import { useEffect, useState } from "react";

export interface Plano {
  id: number;
  nome: string;
  qtd_consultas_gratis: number;
  desconto: number;
}

interface ListaPanosProps {
  onEdit?: (plano: Plano) => void;
  onDelete?: (plano: Plano) => void;
}

export const ListaPlanos: React.FC<ListaPanosProps> = ({
  onEdit = () => {},
  onDelete = () => {},
}) => {
  const [planos, setPlanos] = useState<Plano[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const { listarPlanos } = useServicePlano();

  useEffect(() => {
    async function carregar() {
      try {
        setLoading(true);
        const dados = await listarPlanos();
        setPlanos(dados);
      } catch (error) {
        console.error("Erro ao buscar planos:", error);
      } finally {
        setLoading(false);
      }
    }
    carregar();
  }, []);

  const handleDelete = async (plano: Plano) => {
    try {
        
      setPlanos((prev) => prev.filter((p) => p.id !== plano.id));
      onDelete(plano);
    } catch (error) {
      console.error("Erro ao deletar plano:", error);
    }
  };

  if (loading) {
    return (
      <div className="w-full p-8 text-center bg-white rounded-2xl border border-slate-200/80 shadow-sm text-sm text-slate-500">
        Carregando planos...
      </div>
    );
  }

  return (
    <div className="w-full bg-white rounded-2xl border border-slate-200/80 shadow-sm overflow-hidden">
      <div className="max-h-[calc(100vh-220px)] overflow-y-auto overflow-x-auto">
        <table className="w-full text-left border-collapse">
          <thead className="sticky top-0 z-10 bg-slate-50 border-b border-slate-200/80 shadow-xs">
            <tr className="text-[11px] font-bold text-slate-400 uppercase tracking-wider">
              <th className="py-4 px-6 bg-slate-50">Código</th>
              <th className="py-4 px-6 bg-slate-50">Nome do Plano</th>
              <th className="py-4 px-6 bg-slate-50">Qtd. Grátis</th>
              <th className="py-4 px-6 bg-slate-50">Desconto</th>
              <th className="py-4 px-6 bg-slate-50 text-right w-48">Ações</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-100 text-sm text-slate-700">
            {planos.length === 0 ? (
              <tr>
                <td colSpan={5} className="py-8 text-center text-slate-400 text-xs">
                  Nenhum plano encontrado.
                </td>
              </tr>
            ) : (
              planos.map((plano) => (
                <PlanoRow
                  key={plano.id}
                  plano={plano}
                  onDelete={() => handleDelete(plano)}
                  onEdit={onEdit}
                />
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

interface PlanoRowProps {
  plano: Plano;
  onEdit: (plano: Plano) => void;
  onDelete: (plano: Plano) => void;
}

const PlanoRow: React.FC<PlanoRowProps> = ({ plano, onDelete, onEdit }) => {
  const [deletando, setDeletando] = useState<boolean>(false);

  const onDeleteClick = (p: Plano) => {
    if (deletando) {
      onDelete(p);
    } else {
      setDeletando(true);
    }
  };

  return (
    <tr className="hover:bg-slate-50/60 transition-colors duration-150 group">
      <td className="py-4 px-6 font-semibold text-slate-400 text-xs">
        #{String(plano.id).padStart(3, "0")}
      </td>

      <td className="py-4 px-6 font-semibold text-slate-800">
        {plano.nome}
      </td>

      <td className="py-4 px-6">
        <span className="inline-flex items-center px-2.5 py-1 rounded-lg text-xs font-medium bg-sky-50 text-sky-700 border border-sky-100">
          {plano.qtd_consultas_gratis} {plano.qtd_consultas_gratis === 1 ? "consulta" : "consultas"}
        </span>
      </td>

      <td className="py-4 px-6 font-semibold text-teal-600">
        {plano.desconto}%
      </td>

      <td className="py-4 px-6 text-right w-48">
        <div className="flex items-center justify-end gap-1.5 h-8">
          {!deletando ? (
            <>
              <button
                onClick={() => onEdit(plano)}
                className="p-1.5 text-slate-400 hover:text-teal-600 hover:bg-teal-50 rounded-lg transition-colors cursor-pointer"
                title="Editar"
              >
                <svg className="w-4 h-4 stroke-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path strokeLinecap="round" strokeLinejoin="round" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                </svg>
              </button>

              <button
                onClick={() => onDeleteClick(plano)}
                className="p-1.5 text-slate-400 hover:text-red-600 hover:bg-red-50 rounded-lg transition-colors cursor-pointer"
                title="Deletar"
              >
                <svg className="w-4 h-4 stroke-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path strokeLinecap="round" strokeLinejoin="round" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                </svg>
              </button>
            </>
          ) : (
            <div className="flex items-center gap-1 animate-fadeIn">
              <button
                onClick={() => onDeleteClick(plano)}
                className="px-2.5 py-1 bg-red-600 hover:bg-red-700 text-white rounded-lg text-xs font-semibold transition-colors cursor-pointer shadow-sm"
              >
                Excluir
              </button>
              <button
                onClick={() => setDeletando(false)}
                className="px-2.5 py-1 bg-slate-100 hover:bg-slate-200 text-slate-600 rounded-lg text-xs font-semibold transition-colors cursor-pointer"
              >
                Cancelar
              </button>
            </div>
          )}
        </div>
      </td>
    </tr>
  );
};