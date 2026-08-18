import { Layout } from "./components/layout";
import Head from "next/head";
import type { AppProps } from "next/app";

export default function Home() {
  return (
    <div>

      <Head>
        <title>Whister Agendamentos</title>
      </Head>
      <Layout/>
    </div>
  );
}
